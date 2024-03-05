package com.rk.oop.practice.calculator.command;

import com.rk.oop.practice.calculator.Calculator;

public abstract class Command {

    final Calculator calculator;
    final double operand;
    private double backup = 0;

    public Command(Calculator calculator, double operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        this.saveBackup();
    };
    public void undo() {
        this.calculator.setResult(this.backup);
    };

    void saveBackup() {
        this.backup = this.calculator.getResult();
    }
}
