package com.spring.workshop.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {
    public  String retrieveSomeData() {
        return "Hello Data2";
    }
}
