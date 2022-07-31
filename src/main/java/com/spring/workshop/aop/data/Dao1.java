package com.spring.workshop.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    public  String retrieveSomeData() {
        return "Hello Data1";
    }

}
