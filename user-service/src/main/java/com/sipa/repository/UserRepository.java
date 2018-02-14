package com.sipa.repository;

import com.sipa.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {

    User findByLogin(String login);
}
