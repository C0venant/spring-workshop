package com.spring.workshop.aop.service;

import com.spring.workshop.aop.data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessor1 {

    @Autowired
    private Dao1 dao1;

    public String process() {
        return dao1.retrieveSomeData();
    }
}
