package com.spring.workshop.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = "/hello")
    @ResponseBody//wihtout this Hello world will be regarded as dispatched url adn will give 404
    public String sayHello() {
        return "Hello world";
    }
}
