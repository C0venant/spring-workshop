package com.spring.workshop.aop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Aspect// AOP stuff
@Configuration
public class AroundAspect {

    //good for benchmarking
    //around allows to intercept and then allow method to continue working
    @Around("com.spring.workshop.aop.aspect.config.CommonJoinPointConfig.trackTimeAnnotation()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        //start time
        //allow method execution
        //finish - start = total execution time
        long start = System.currentTimeMillis();
        var res = joinPoint.proceed();
        //can be used to check something before execution
        long executionTime =  System.currentTimeMillis() - start;
        log.info("{} took {} milliseconds to complete", joinPoint, executionTime);
        return res;// without this null will be returned
    }

}
