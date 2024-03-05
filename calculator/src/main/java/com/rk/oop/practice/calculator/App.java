package com.rk.oop.practice.calculator;

public class App {
    public static void main(String [] args) {
        Calculator calculator = new Calculator();

        // 7 + 8 - 3

        calculator.add(7);
        calculator.add(8);
        calculator.subtract(3);
        System.out.println(calculator.getResult()); // 12

        calculator.undo();
        System.out.println(calculator.getResult()); // 15

        calculator.undo();
        System.out.println(calculator.getResult()); // 7

        calculator.undo();
        System.out.println(calculator.getResult()); // 0
    }
}
