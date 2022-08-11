package com.spring.workshop.databaseJpa;


import com.spring.workshop.databaseJpa.entity.PersonEntity;
import com.spring.workshop.databaseJpa.repository.PersonJpaRepository;
import com.spring.workshop.databaseSpringJdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringWorkshopApplication implements CommandLineRunner {

    @Autowired
    private PersonJpaRepository personJpaRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringWorkshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personJpaRepository.update(getPerson());
        System.out.println(personJpaRepository.findById(1));
    }

    PersonEntity getPerson() {
        return new PersonEntity("n", "loc", new Date());
    }


}
