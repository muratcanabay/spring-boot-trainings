package com.muratcanabay.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Before("execution(* com.muratcanabay.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("Order 1: " + joinPoint.getSignature());
    }

    @AfterReturning("execution(* com.muratcanabay.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("Order 2: " + joinPoint.getSignature());
    }

    @After("execution(* com.muratcanabay.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("Order 3: " + joinPoint.getSignature());
    }

    /**
     * Runs if error occurred
     *
     * @param joinPoint
     */
    @AfterThrowing("execution(* com.muratcanabay.service.*.*(..))")
    public void ifThrows(JoinPoint joinPoint) {
        System.out.println("Error: " + joinPoint.getSignature());
    }
}
