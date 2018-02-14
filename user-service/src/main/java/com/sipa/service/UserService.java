package com.sipa.service;

import com.sipa.domain.User;
import com.sipa.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLogin (String login) {
        return userRepository.findByLogin(login);
    }
}
