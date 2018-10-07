package com.hannt.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorConfigurationTest {
    @Test
    public void add(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        ArithmeticCalculator calculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        double result = calculator.add(1, 2);

        assertEquals(3, result);
    }

    @Test
    public void sub(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        ArithmeticCalculator calculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        double result = calculator.sub(3, 2);

        assertEquals(1, result);
    }

    @Test
    public void mul(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        ArithmeticCalculator calculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        double result = calculator.mul(2, 3);

        assertEquals(6, result);
    }
}