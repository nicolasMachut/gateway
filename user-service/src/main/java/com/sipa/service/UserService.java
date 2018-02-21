package com.sipa.service;

import com.sipa.domain.EntityValue;
import com.sipa.domain.UserValue;
import com.sipa.domain.WorkspaceValue;
import com.sipa.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserValue getUserByLogin (String login) {
        return userRepository.findByLogin(login);
    }

    public void createDefaultAdminUser(EntityValue entity) {
        UserValue userValue = new UserValue();
        userValue.setEntity(entity);
        userValue.setLogin(entity.getName());
        userValue.setPassword(bCryptPasswordEncoder.encode("admin"));
        userValue.setMail("admin@admin.fr");

        WorkspaceValue workspaceValue = new WorkspaceValue();
        workspaceValue.setId(1L);
        userValue.setWorkspace(workspaceValue);
        this.createUser(userValue);
    }

    public UserValue createUser (UserValue userValue) {
        return this.userRepository.save(userValue);
    }
}
