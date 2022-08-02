package com.spring.workshop.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private String location;
    private Date birthDate;
}
