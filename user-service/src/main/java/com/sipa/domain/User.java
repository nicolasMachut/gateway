package com.sipa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "users")
@Data
public class User {

    @Id
    private Long id;

    @ManyToOne
    private Workspace workspace;

    @ManyToOne
    private com.sipa.domain.Entity entity;

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
