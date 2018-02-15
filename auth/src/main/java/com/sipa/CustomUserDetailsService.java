package com.sipa;

import com.sipa.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        String url = "http://localhost:8787/userTest/" + s;
        UserDto userDto = new RestTemplate().getForObject(url, UserDto.class);
        if (userDto != null) {
            return new CustomUserDetails(userDto);
        } else {
            throw new UsernameNotFoundException(s);
        }
    }
}
