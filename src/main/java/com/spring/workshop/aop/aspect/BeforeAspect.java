package com.spring.workshop.aop.aspect;

//AOP configuration

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Aspect// AOP stuff
@Configuration
public class BeforeAspect {

    //intercept everything in this package
    @Before("com.spring.workshop.aop.aspect.config.CommonJoinPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint) {
        //can be used to check something before execution
        log.info("Intercepted method calls - {}", joinPoint);
    }


}
