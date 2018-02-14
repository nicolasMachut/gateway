package com.sipa;

import lombok.Data;

@Data
public class UserDto {

    private Long personId;
    private Long workspaceId;
    private String login;
    private String password;
    private String mail;
    private Integer role;
    private Boolean active;
}
