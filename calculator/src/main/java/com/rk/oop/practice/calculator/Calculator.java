package com.rk.oop.practice.calculator;

import com.rk.oop.practice.calculator.command.Add;
import com.rk.oop.practice.calculator.command.Command;
import com.rk.oop.practice.calculator.command.Subtract;

import java.util.Stack;

public class Calculator {
    private Stack<Command> commandStack;
    private double result = 0;
    private Calculator calculator;

    public Calculator() {
        this.commandStack = new Stack<>();
    }

    public Calculator getInstance() {
        if (this.calculator == null) {
            this.calculator = new Calculator();
        }
        return this.calculator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void add(double operand) {
        this.executeCommand(new Add(this, operand));
    }

    public void subtract(double operand) {
        this.executeCommand(new Subtract(this, operand));
    }

    private void executeCommand(Command command) {
        command.execute();
        this.commandStack.push(command);
    }

    public void undo() {
        if (!this.commandStack.empty()) {
            // Undo prev command.
            this.commandStack.pop().undo();
        };
    }
}
