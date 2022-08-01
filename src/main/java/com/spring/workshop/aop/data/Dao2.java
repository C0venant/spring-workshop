package com.spring.workshop.aop.data;

import com.spring.workshop.aop.aspect.annotation.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

    @TrackTime
    public  String retrieveSomeData() {
        return "Hello Data2";
    }
}
