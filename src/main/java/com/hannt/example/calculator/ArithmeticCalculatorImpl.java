package com.hannt.example.calculator;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public double add(double a, double b) {
        final double result = a+b;
        System.out.printf("%f+%f=%f", a, b, result);
        return result;
    }

    @Override
    public double sub(double a, double b) {
        final double result = a-b;
        System.out.printf("%f-%f=%f", a, b, result);
        return result;
    }

    @Override
    public double mul(double a, double b) {
        final double result = a * b;
        System.out.printf("%f*%f=%f", a, b, result);
        return result;
    }

    @Override
    public double div(double a, double b) {
        if(b == 0) throw new IllegalArgumentException("Division by zero");

        final double result = a / b;
        System.out.printf("%f/%f=%f", a, b, result);
        return result;
    }
}
