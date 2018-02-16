package com.sipa.domain;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
