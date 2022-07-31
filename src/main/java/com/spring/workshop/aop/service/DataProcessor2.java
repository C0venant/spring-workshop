package com.spring.workshop.aop.service;

import com.spring.workshop.aop.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessor2 {

    @Autowired
    private Dao2 dao2;

    public String process() {
        return dao2.retrieveSomeData();
    }
}
