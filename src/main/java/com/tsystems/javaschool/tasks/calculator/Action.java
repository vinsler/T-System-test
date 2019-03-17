package com.tsystems.javaschool.tasks.calculator;


public class Action {
    private static Operations operations = new Operations();
    private static String expression; // validate exp for actions
    private static String result; // result to return, really need?



    public String actions(){ // result this func return in calculator
        //System.out.println(expression);


        return null;
    }

    public String actionBracket(String localExpression) {
        if (!localExpression.contains("'(")) {
            return easyAction(localExpression); // easyAction
        }
        return result;
    }

    public String easyAction(String localExpression) {
        while (localExpression.contains("*")) {
            localExpression = subForEasyAction(localExpression, "*");
        }

        // todo all exp

        return null;
    }

    private String subForEasyAction(String deepLocalExpression, String operator) { // sub function
        int position = deepLocalExpression.indexOf(operator);
        int strStart = -5, strEnd = -5; // impossible position

        for (int i = position; i < deepLocalExpression.length(); i++) {
            if ((position - i) > 0) {
                if (Character.toString(deepLocalExpression.charAt(position - i)).equals(operator)) {
                    if (strStart == -5) {
                        strStart = position - i;
                    }
                }
            }
            if ((position + 1) < deepLocalExpression.length()) {
                if (Character.toString(deepLocalExpression.charAt(position + i)).equals(operator)) {
                    if (strEnd == -5) {
                        strEnd = position + i;
                    }
                }
            }
        }
        return operations.mult(
                Double.parseDouble(deepLocalExpression.substring(strStart, position - 1)),
                Double.parseDouble(deepLocalExpression.substring(position + 1, strEnd))).toString();
    }


    public Action(String expression) {
        this.expression = expression;
    }
}
