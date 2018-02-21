package com.sipa.domain;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity(name = "co_workspace")
@Data
public class WorkspaceValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}
