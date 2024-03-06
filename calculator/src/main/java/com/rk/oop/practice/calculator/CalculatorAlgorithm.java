package com.rk.oop.practice.calculator;

import java.util.*;

public class CalculatorAlgorithm {
    public double calculate(String s) {
        List<Character> arr = new ArrayList<>();

        for (char c : s.toCharArray()) {
            arr.add(c);
        }

        System.out.println(arr);

        return helper(arr);
    }

    public double helper(List<Character> s) {
        if (s.size() == 0) {
            return 0;
        }

        Stack<Double> stack = new Stack<>();
        char sign = '+';
        double num = 0;

        while (s.size() > 0) {
            char c = s.remove(0);

            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            }
            if (c == '(') {
                num = helper(s);
            }
            if (s.size() == 0 || (c == '+' || c == '-' || c == '*' || c == '/' || c == ')')) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.set(stack.size() - 1, stack.peek() * num);
                } else if (sign == '/') {
                    stack.set(stack.size() - 1, (stack.peek() / num));
                }
                sign = c;
                num = 0;
                if (sign == ')') {
                    break;
                }
            }
        }

        double sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}

