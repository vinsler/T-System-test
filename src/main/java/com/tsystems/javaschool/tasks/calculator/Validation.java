package com.tsystems.javaschool.tasks.calculator;

import java.util.Stack;

public class Validation {
    private boolean validate;

    private boolean calculate(String expression) {
        if (expression == null) {
            return false;
        }

        if (expression.length() == 0) {
            return false;
        }

        if (expression.contains(",")
                || expression.contains(" ")
                || expression.contains("**")
                || expression.contains("//")
                || expression.contains("++")
                || expression.contains("*/")
                || expression.contains("*+")
                || expression.contains("/*")
                || expression.contains("/+")
                || expression.contains("+*")
                || expression.contains("+/")
                || expression.contains("+-")
                || expression.contains("-*")
                || expression.contains("-/")
                || expression.contains("-+")
                || expression.contains("--")
                || expression.contains("..")
        ) {
            return false;
        }

        Character ch = expression.charAt(0);
        if (ch == '+' || ch == '*' || ch == '/' || ch == ')') {
            return false;
        }

        ch = expression.charAt(expression.length() - 1);
        if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(expression.charAt(i));
                if (i != 0) { // without sign after numeral and before "("
                    if ((expression.charAt(i - 1) != '*') &&
                            (expression.charAt(i - 1) != '/') &&
                            (expression.charAt(i - 1) != '+') &&
                            (expression.charAt(i - 1) != '-')
                    ) {
                        return false;
                    }
                }
            } else if (expression.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                if ((expression.charAt(i - 1) == '*') || // sign after numeral and before ")"
                        (expression.charAt(i - 1) == '/') ||
                        (expression.charAt(i - 1) == '+') ||
                        (expression.charAt(i - 1) == '-')

                ) {
                    return false;
                }
                if (i != expression.length() - 1) { // without sign after ")" and before numeral
                    if ((expression.charAt(i + 1) != '*') &&
                            (expression.charAt(i + 1) != '/') &&
                            (expression.charAt(i + 1) != '+') &&
                            (expression.charAt(i + 1) != '-')
                    ) {
                        return false;
                    }
                }
            }
        }
        if (stack.size() > 0) {
            return false;
        }
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