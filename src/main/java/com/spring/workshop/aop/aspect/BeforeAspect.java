package com.spring.workshop.aop.aspect;

//AOP configuration

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Aspect// AOP stuff
@Configuration
public class BeforeAspect {

    //intercept everything in this package
    @Before("execution(* com.spring.workshop.aop.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //can be used to check something before execution
        log.info("Intercepted method calls - {}", joinPoint);
    }

}
