package com.tsystems.javaschool.tasks.calculator;


public class Action {
    private static Operations operations = new Operations();
    private static String expression; // validate exp for actions
    private static String result; // result to return, really need?



    public String actions(){ // result this func return in calculator
        System.out.println(expression);

        return easyAction(expression);
    }

    public String undoParantheses(String localExpression) {
        while (localExpression.contains("(")) {
            //todo search "(" do substring between ")" do easyAction return result in string without Parantheses
        }
        return localExpression;
    }

    public String easyAction(String localExpression) {
        while (localExpression.contains("*")) {
            localExpression = subForEasyAction(localExpression, "*");
        }
        while (localExpression.contains("/")) {
            localExpression = subForEasyAction(localExpression, "/");
        }
        while (localExpression.contains("+")) {
            if (localExpression.lastIndexOf('+') == 0) {
                localExpression = localExpression.substring(1, localExpression.length());
                break;
            }
            localExpression = subForEasyAction(localExpression, "+");
        }
        while (localExpression.contains("-")) {
            if (localExpression.lastIndexOf('-') == 0) {
                break;
            }
            localExpression = subForEasyAction(localExpression, "-");
        }

        // todo all exp from left to right

        return localExpression;
    }

    private String subForEasyAction(String deepLocalExpression, String operator) { // sub function
        int position = deepLocalExpression.indexOf(operator);
        int strStart = -5, strEnd = -5; // impossible position

        for (int i = 1; i < deepLocalExpression.length(); i++) {
            if ((position - i) > -1) {
                String strTemp = Character.toString(deepLocalExpression.charAt(position - i));
                if (strTemp.equals("*") || strTemp.equals("/") || strTemp.equals("+") || strTemp.equals("-")) {
                    if (strStart == -5) {
                        if (strTemp.equals("-")) {
                            strStart = position - i;
                        } else {
                            strStart = position - i + 1;
                        }
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
                    strEnd = deepLocalExpression.length();
                }
            }
        }
        String leftSideFromSign = deepLocalExpression.substring(strStart, position);
        String rightSideFromSign = deepLocalExpression.substring(position + 1, strEnd);
        String result;

        if (leftSideFromSign.contains(".") || rightSideFromSign.contains(".")) {
            result = doResult(leftSideFromSign, rightSideFromSign, 1, operator);
            result = checkMinusResult(leftSideFromSign, result);
        } else {
            result = doResult(leftSideFromSign, rightSideFromSign, 0, operator);
            result = checkMinusResult(leftSideFromSign, result);
        }

        return deepLocalExpression.substring(0, strStart)
                + result
                + deepLocalExpression.substring(strEnd, deepLocalExpression.length());
    }

    private String checkMinusResult(String leftSideFromSign, String result){
        if (leftSideFromSign.charAt(0) == '-') {
            if (result.charAt(0) == '-') {
                return result = '-' + result;
            } else {
                return result = '+' + result;
            }
        }
        return result;
    }

    private String doResult(String leftSideFromSign, String rightSideFromSign, int intOrDbl, String operator){
        if (intOrDbl == 0) {
            switch (operator) {
                case "*": {
                    result = Integer.toString(operations.mult(
                            Integer.parseInt(leftSideFromSign),
                            Integer.parseInt(rightSideFromSign)));
                    break;
                }
                case "/": {
                    try {
                        result = Integer.toString(operations.div(
                                Integer.parseInt(leftSideFromSign),
                                Integer.parseInt(rightSideFromSign)));
                    } catch (NullPointerException npe) {
                    }
                    break;
                }
                case "+": {
                    result = Integer.toString(operations.sum(
                            Integer.parseInt(leftSideFromSign),
                            Integer.parseInt(rightSideFromSign)));
                    break;
                }
                case "-": {
                    result = Integer.toString(operations.diff(
                            Integer.parseInt(leftSideFromSign),
                            Integer.parseInt(rightSideFromSign)));
                    break;
                }
            }
        } else {
            switch (operator) {
                case "*": {
                    result = operations.mult(
                            Double.parseDouble(leftSideFromSign),
                            Double.parseDouble(rightSideFromSign)).toString();
                    break;
                }
                case "/": {
                    result = operations.div(
                            Double.parseDouble(leftSideFromSign),
                            Double.parseDouble(rightSideFromSign)).toString();
                    break;
                }
                case "+": {
                    result = operations.sum(
                            Double.parseDouble(leftSideFromSign),
                            Double.parseDouble(rightSideFromSign)).toString();
                    break;
                }
                case "-": {
                    result = operations.diff(
                            Double.parseDouble(leftSideFromSign),
                            Double.parseDouble(rightSideFromSign)).toString();
                    break;
                }
            }
        }
        return result;
    }


    public Action(String expression) {
        this.expression = expression;
    }
}
