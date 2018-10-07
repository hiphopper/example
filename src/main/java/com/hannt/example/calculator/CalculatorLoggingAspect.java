package com.hannt.example.calculator;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class CalculatorLoggingAspect {

    @Before("execution(* ArithmeticCalculator.add(..))")
    public void logBefore(){
        log.info("The method add() begins");
    }

    @Before("execution(* *.*(..))")
    public void logBeforeAll(JoinPoint joinPoint){
        log.info("The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }
}
