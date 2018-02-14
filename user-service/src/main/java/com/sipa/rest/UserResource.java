package com.sipa.rest;

import com.sipa.domain.User;
import com.sipa.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userTest")
public class UserResource {

    private final UserService userService;

    public UserResource (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{login}")
    public User getUserByLogin (@PathVariable("login") String login) {
        return userService.getUserByLogin(login);
    }
}
