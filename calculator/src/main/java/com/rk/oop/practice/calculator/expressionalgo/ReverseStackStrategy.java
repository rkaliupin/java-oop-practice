package com.rk.oop.practice.calculator.expressionalgo;

import com.rk.oop.practice.calculator.Calculator;

public class ReverseStackStrategy implements FullExpressionCalculationStrategy {
    private final Calculator calculator;

    public ReverseStackStrategy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double getResult() {
        return 0;
    }
}
