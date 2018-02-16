package com.sipa.service;

import com.sipa.dto.UserDto;
import com.sipa.domain.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // TODO : paramétrer url
        String url = "http://localhost:8787/user/" + s;
        UserDto userDto = new RestTemplate().getForObject(url, UserDto.class);
        if (userDto != null) {
            return new CustomUserDetails(userDto);
        } else {
            throw new UsernameNotFoundException(s);
        }
    }
}
