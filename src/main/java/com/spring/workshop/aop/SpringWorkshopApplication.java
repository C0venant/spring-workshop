package com.spring.workshop.aop;

import com.spring.workshop.aop.service.DataProcessor1;
import com.spring.workshop.aop.service.DataProcessor2;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SpringWorkshopApplication implements CommandLineRunner {

    @Autowired
    DataProcessor1 dataProcessor1;

    @Autowired
    DataProcessor2 dataProcessor2;

    public static void main(String[] args) {
        SpringApplication.run(SpringWorkshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(dataProcessor1.process());
        log.info(dataProcessor2.process());
    }
}
