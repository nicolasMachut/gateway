package com.sipa.repository;

import com.sipa.domain.UserValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <UserValue, Long> {

    UserValue findByLogin(String login);
}
