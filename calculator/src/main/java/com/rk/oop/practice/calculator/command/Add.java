package com.rk.oop.practice.calculator.command;

import com.rk.oop.practice.calculator.Calculator;

public class Add extends Command {
    public Add(Calculator calculator, double operand) {
        super(calculator, operand);
    }
    @Override
    public void execute() {
        super.execute();
        this.calculator.setResult(
                this.calculator.getResult() + this.operand
        );
    }
}
