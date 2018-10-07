package com.hannt.example.calculator;

import org.springframework.stereotype.Component;

@Component("unitCalculator")
public class UnitCalculatorImpl implements UnitCalculator {
    @Override
    public double kilogramToPound(double kilogram) {
        final double pound = kilogram * 2.2;
        System.out.printf("%d kilogram = %d pound");
        return pound;
    }

    @Override
    public double kilometerToMile(double kilometer) {
        final double mile = kilometer * 0.62;
        System.out.printf("%d kilometer = %d mile");
        return mile;
    }
}
