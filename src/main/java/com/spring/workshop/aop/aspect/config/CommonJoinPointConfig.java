package com.spring.workshop.aop.aspect.config;

import org.aspectj.lang.annotation.Pointcut;

//this is used configure join point which is used in a lot of aspects
//join points are defined by aspectJ
public class CommonJoinPointConfig {


    //&& can be used to have multiple execution paths
    @Pointcut("execution(* com.spring.workshop.aop.service.*.*(..))")
    public void dataLayerExecution() {}

    //takes bean name as regular expression
    @Pointcut("bean(*dao*)")
    public void beanExecution(){}

    //configure custom annotation to apply specific aspect (tracks time in this case)
    @Pointcut("@annotation(com.spring.workshop.aop.aspect.annotation.TrackTime)")
    public void trackTimeAnnotation(){}
}

