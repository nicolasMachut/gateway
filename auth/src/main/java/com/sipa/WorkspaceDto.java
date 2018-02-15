package com.sipa;

import lombok.Data;

@Data
public class WorkspaceDto {
    private Long id;
    private EntityDto entity;
    private String name;
    private byte[] actions;
}
