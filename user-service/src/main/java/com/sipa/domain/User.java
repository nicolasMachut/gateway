package com.sipa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
@Data
public class User {

    @Id
    private Long personId;

    @Column
    private Long workspaceId;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String mail;

    @Column
    private Integer role;

    @Column
    private Boolean active;
}
