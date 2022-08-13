package com.spring.workshop.databaseJpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@NamedQuery(name = "find_all", query = "select p from PersonEntity p")
@Entity // person_entity table will be created
@NoArgsConstructor // this is mandatory
@Data
public class PersonEntity {
    @Id
    @GeneratedValue //id is auto generated
    private int id;

    private String name;

    private String location;

    private Date birthDate;

    public PersonEntity( String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

}
