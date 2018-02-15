package com.sipa.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long personId;
    private WorkspaceDto workspace;
    private EntityDto entity;
    private String login;
    private String password;
    private String mail;
    private Integer role;
    private Boolean active;
}
