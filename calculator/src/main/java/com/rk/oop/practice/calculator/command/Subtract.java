package com.rk.oop.practice.calculator.command;

import com.rk.oop.practice.calculator.Calculator;

public class Subtract extends Command {
    public Subtract(Calculator calculator, double operand) {
        super(calculator, operand);
    }

    @Override
    public void execute() {
        super.execute();
        this.calculator.setResult(
                this.calculator.getResult() - this.operand
        );
    }
}
