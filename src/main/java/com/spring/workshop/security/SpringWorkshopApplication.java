package com.spring.workshop.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
//authentication - checking credentials
//authorization - checking role of authenticated user for action
public class SpringWorkshopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringWorkshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
