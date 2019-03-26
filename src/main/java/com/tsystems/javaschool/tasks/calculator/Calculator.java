package com.tsystems.javaschool.tasks.calculator;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */

    public String evaluate(String statement) {
        Validation validation = new Validation(statement); // validate expression

        if (validation.isValidate()){
            System.out.println("Access granted!");
            Action action = new Action(statement); // if validate then calculate, else null

            return action.actions();
        }
        System.out.println("Access denied!");
        return null;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.evaluate("-10/(3+4/2)")); // 10/(2-7+3)*4
    }

}
