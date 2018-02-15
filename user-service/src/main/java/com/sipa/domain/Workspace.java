package com.sipa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "workspace")
@Data
public class Workspace {

    @Id
    private Long id;

    @ManyToOne
    private com.sipa.domain.Entity entity;

    @Column
    private String name;

    @Column
    private byte[] actions;
}
