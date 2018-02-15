package com.sipa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@javax.persistence.Entity(name = "entity")
@Data
public class Entity {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Boolean active;

    @Column
    private Long parentId;
}
