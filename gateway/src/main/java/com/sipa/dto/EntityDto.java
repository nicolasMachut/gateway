package com.sipa.dto;

import lombok.Data;

@Data
public class EntityDto {

    private Long id;
    private String name;
    private String description;
    private Long parentId;
}
