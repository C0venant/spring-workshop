package com.spring.workshop.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleApi {

    @GetMapping("/")
    public String homePage() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "<h1>Welcome admin</h1>";
    }

    @GetMapping("/user")
    public String userPage() {
        return "<h1>Welcome user</h1>";
    }

}
