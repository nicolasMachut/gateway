package com.sipa;

import lombok.Data;

@Data
public class EntityDto {

    private Long id;
    private String name;
    private String description;
    private Boolean active;
    private Long parentId;
}
