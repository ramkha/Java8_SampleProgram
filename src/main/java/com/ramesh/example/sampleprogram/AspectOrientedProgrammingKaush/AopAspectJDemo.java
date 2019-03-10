package com.ramesh.example.sampleprogram.AspectOrientedProgrammingKaush;

/*
    Aspect Oriented programming (AOP) :-
    =>  First lets see what is the problems in our functional and OOP architecture. Lets say if we have a common method/functionality
      used repeatedly by most objects then the problems become ;
        ~ Too many relationship to the crosscutting object
        ~ Code is still required in all methods
        ~ Code changed cannot be achieved at once
     In real time world example, Logging, Transactions and Security are the cross-cutting concerns, and AOP helps to solve this concerns.

    ~ Pointcut: the expression used to define when a call to a method should be intercepted. In the above example, execution(* com.in28minutes.springboot.tutorial.basics.
                example.aop.data.*.*(..)) is the pointcut.
    ~ Advice: What do you want to do? An advice is the logic that you want to invoke when you intercept a method. In the above example,
            it is the code inside the before(JoinPoint joinPoint) method.
    ~ Aspect: A combination of defining when you want to intercept a method call (Pointcut) and what to do (Advice) is called an Aspect.
    ~ Join Point: When the code is executed and the condition for pointcut is met, the advice is executed. The Join Point is a specific execution instance of an advice.
    ~ Weaver: Weaver is the framework that implements AOP — AspectJ or Spring AOP.

    Using the @After, @AfterReturning, and @AfterThrowing Advices
    ~ @After: executed in two situations — when a method executes successfully or it throws an exception.
    ~ @AfterReturning: executed only when a method executes successfully.
    ~ @AfterThrowing: executed only when a method throws an exception.

    Steps in AOP
     ~ Write Aspects
     ~ configure where the aspects apply

 */

class triangle {


}
public class AopAspectJDemo {




}
