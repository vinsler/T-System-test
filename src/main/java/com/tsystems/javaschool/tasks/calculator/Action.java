package com.tsystems.javaschool.tasks.calculator;


public class Action {
    private static Operations operations = new Operations();
    private static String expression; // validate exp for actions
    private static String result; // result to return, really need?



    public String actions(){ // result this func return in calculator
        System.out.println(expression);

        return easyAction(expression);
    }

    public String actionBracket(String localExpression) {
        if (!localExpression.contains("(")) {
            return easyAction(localExpression); // easyAction
        }
        return result;
    }

    public String easyAction(String localExpression) {
        while (localExpression.contains("*")) {
            localExpression = subForEasyAction(localExpression, "*");
        }

        // todo all exp

        return localExpression;
    }

    private String subForEasyAction(String deepLocalExpression, String operator) { // sub function
        int position = deepLocalExpression.indexOf(operator);
        int strStart = -5, strEnd = -5; // impossible position

        for (int i = position; i < deepLocalExpression.length(); i++) {
            if ((position - i) > -1) {
                String strTemp = Character.toString(deepLocalExpression.charAt(position - i));
                if (strTemp.equals("*") || strTemp.equals("/") || strTemp.equals("+") || strTemp.equals("-")) {
                    if (strStart == -5) {
                        strStart = position - i;
                    }
                }
            } else {
                if (strStart == -5) {
                    strStart = 0; // first number of expression
                }
            }
            if ((position + i) < deepLocalExpression.length()) {
                String strTemp = Character.toString(deepLocalExpression.charAt(position + i));
                if (strTemp.equals("*") || strTemp.equals("/") || strTemp.equals("+") || strTemp.equals("-")) {
                    if (strEnd == -5) {
                        strEnd = position + i;
                    }
                }
            } else {
                if (strEnd == -5) {
                    strEnd = deepLocalExpression.length() - 1;
                }
            }
        }
        String leftSideFromSign = deepLocalExpression.substring(strStart, position);
        String rightSideFromSign = deepLocalExpression.substring(position + 1, strEnd + 1);
        if (leftSideFromSign.contains(".") || rightSideFromSign.contains(".")) {
              return operations.mult(
                      Double.parseDouble(leftSideFromSign),
                      Double.parseDouble(rightSideFromSign)).toString();
        }

        return Integer.toString(operations.mult(
                Integer.parseInt(leftSideFromSign),
                Integer.parseInt(rightSideFromSign)));
    }


    public Action(String expression) {
        this.expression = expression;
    }
}
