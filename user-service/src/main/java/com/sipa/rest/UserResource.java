package com.sipa.rest;

import com.sipa.UserServiceException;
import com.sipa.domain.UserValue;
import com.sipa.domain.WorkspaceValue;
import com.sipa.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserResource(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(value = "/{login}")
    public UserValue getUserByLogin (@PathVariable("login") String login) {
        return userService.getUserByLogin(login);
    }

    @PostMapping
    public ResponseEntity<UserValue> createUser(@RequestBody @Valid UserValue userValue) throws UserServiceException {
        userValue.setPassword(bCryptPasswordEncoder.encode("password"));
        WorkspaceValue workspaceValue = new WorkspaceValue();
        workspaceValue.setId(1L);
        userValue.setWorkspace(workspaceValue);
        UserValue createdUser =  userService.createUser(userValue);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    // Services
    // cartegie(4), pouey(3), autovista(2), siv(1)
    // https://pomelos.io/fisheye/browse/SPI/src/main
}
