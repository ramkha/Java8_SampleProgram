package com.ramesh.example.sampleprogram.AspectOrientedProgrammingKaush.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class LoggingAspect {

    @Before("execution(com.ramesh.example.sampleprogram.AspectOrientedProgrammingKaush.Circle.getName())")
    public void before(JoinPoint joinPoint){
    System.out.println("Advice run. Get method called");
    System.out.println(joinPoint.getSignature().getName());
    }
}
