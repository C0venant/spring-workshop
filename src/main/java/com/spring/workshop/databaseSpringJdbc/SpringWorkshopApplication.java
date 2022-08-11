package com.spring.workshop.databaseSpringJdbc;

import com.spring.workshop.databaseSpringJdbc.dao.PersonDao;
import com.spring.workshop.databaseSpringJdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringWorkshopApplication implements CommandLineRunner {

    @Autowired
    PersonDao personDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringWorkshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(personDao.insert(getPerson()));
        var person = getPerson();
        person.setName("tt");
        personDao.update(person);
        System.out.println(personDao.findAll());
    }


    Person getPerson() {
        return new Person(3, "n", "loc", new Date());
    }
}
