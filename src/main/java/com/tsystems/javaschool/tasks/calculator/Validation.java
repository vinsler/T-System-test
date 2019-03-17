package com.tsystems.javaschool.tasks.calculator;

import java.util.Stack;

public class Validation {
    private boolean validate;

    private boolean calculate(String expression){
        if (expression == null) {
            return false;
        }

        if (expression.length() == 0) { // "" ?
            return false;
        }

        if (expression.contains(",")
                || expression.contains(" ")
                || expression.contains("**")
                || expression.contains("//")
                || expression.contains("++")
                || expression.contains("--")
                || expression.contains("..")) {
            return false;
        }

        Character ch = expression.charAt(0);

        if (ch == '+' || ch == '*' || ch == '/' || ch == ')') {
            return false;
        }

        // validate correct bracket () (()) ((()))
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        // todo validate correct empty brackets



        return true;
    }

    public boolean isValidate() {
        return validate;
    }

    public Validation(String expression) {
        if (calculate(expression)) {
            validate = true;
        }
    }
}
