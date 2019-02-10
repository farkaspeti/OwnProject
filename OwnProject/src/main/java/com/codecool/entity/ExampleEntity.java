package com.codecool.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ExampleEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String exampleName;

    public ExampleEntity(String exampleName) {
        this.exampleName = exampleName;
    }

    public ExampleEntity() {

    }
}
