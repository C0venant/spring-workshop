package com.spring.workshop.jwt;

import com.spring.workshop.jwt.domain.AppUser;
import com.spring.workshop.jwt.domain.Role;
import com.spring.workshop.jwt.repository.UserRepository;
import com.spring.workshop.jwt.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Log4j2
@SpringBootApplication
//authentication - checking credentials
//authorization - checking role of authenticated user for action
public class SpringWorkshopApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringWorkshopApplication.class, args);
    }


    @Bean//used in security config
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        userService.saveRole(new Role(0, "ROLE_USER"));
        userService.saveRole(new Role(0, "ROLE_ADMIN"));
        userService.saveUser(new AppUser(0, "user", "u1", "123", List.of()));
        userService.saveUser(new AppUser(0, "admin", "u2", "123", List.of()));
        userService.addRoleToUser("u1", "ROLE_USER");
        userService.addRoleToUser("u2", "ROLE_USER");
        userService.addRoleToUser("u2", "ROLE_ADMIN");
        System.out.println(userService.getUsers());
    }
}
