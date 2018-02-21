package com.sipa.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "co_entity")
@Data
public class EntityValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String description;

    @Column
    private Long parentId;
}
