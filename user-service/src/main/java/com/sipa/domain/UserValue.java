package com.sipa.domain;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name="co_user")
@Data
public class UserValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private WorkspaceValue workspace;

    @ManyToOne
    @NotNull
    private EntityValue entity;

    @Column
    @NotNull
    private String login;

    @Column
    private String password;

    @Column
    @NotNull
    private String mail;
}