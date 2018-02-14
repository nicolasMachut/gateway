package com.sipa;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final RestTemplate restTemplate;

    public CustomUserDetailsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        String url = "http://localhost:8787/userTest/" + s;
        UserDto userDto = restTemplate.getForObject(url, UserDto.class);
        if (userDto != null) {
            return new CustomUserDetails(userDto);
        } else {
            throw new UsernameNotFoundException(s);
        }
    }
}
