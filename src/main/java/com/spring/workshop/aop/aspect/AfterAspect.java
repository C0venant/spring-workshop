package com.spring.workshop.aop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Aspect// AOP stuff
@Configuration
public class AfterAspect {
    //intercepts when completed successfully
    @AfterReturning(value="com.spring.workshop.aop.aspect.CommonJoinPointConfig.dataLayerExecution()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{} returned with value {}", joinPoint, result);
    }

    //intercepts when exception occurs
    @AfterThrowing(value="com.spring.workshop.aop.aspect.CommonJoinPointConfig.dataLayerExecution()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.info("{} threw exception {}", joinPoint, exception);
    }

    //intercepts after finish whether it completed successfully or not
    @After("com.spring.workshop.aop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void after(JoinPoint joinPoint) {
        log.info("Intercepted method completion - {}", joinPoint);
    }

}
