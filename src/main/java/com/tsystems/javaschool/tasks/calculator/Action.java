package com.tsystems.javaschool.tasks.calculator;


public class Action {
    private static Operations operations = new Operations();
    private static String expression; // validate exp for actions
    private static String result;

    public String actions(){ // result this func return in calculator
        System.out.println(expression);
        return undoParantheses(expression);
    }

    public String undoParantheses(String localExpression) {
        while (localExpression.contains("(")) {
            String inParantheses = easyAction(localExpression.substring(
                    localExpression.lastIndexOf("(") + 1,
                    localExpression.lastIndexOf(")")));
            String leftFromParenteses = localExpression.substring(0, localExpression.lastIndexOf("("));
            String rightFromParentheses = localExpression.substring(
                    localExpression.lastIndexOf(")") + 1,
                    localExpression.length());

            localExpression =leftFromParenteses + inParantheses + rightFromParentheses;
            //todo search "(" do substring between ")" do easyAction return result in string without Parantheses
        }
        localExpression = easyAction(localExpression);
        return localExpression;
    }

    public String easyAction(String localExpression) {
        for (int i = 0; i < localExpression.length(); i++) {
            if (localExpression.charAt(i) == '*') {
                localExpression = subForEasyAction(localExpression, "*");
                i = 0;
            }
            if (localExpression.charAt(i) == '/') {
                localExpression = subForEasyAction(localExpression, "/");
                i = 0;
            }
            if (localExpression == null) {
                return null;
            }
        }
        for (int i = 0; i < localExpression.length(); i++) {
            if (localExpression.charAt(i) == '+') {
                localExpression = subForEasyAction(localExpression, "+");
                i = 0;
            }
            if (localExpression.charAt(i) == '-') {
                if (localExpression.indexOf('-') > 0) { // if not first sign example: -5+3
                    localExpression = subForEasyAction(localExpression, "-");
                    i = 0;
                }
            }
            if (localExpression == null) {
                return null;
            }
        }
        return localExpression;
    }

    private String subForEasyAction(String deepLocalExpression, String operator) { // 10/-2*4
        int position = deepLocalExpression.indexOf(operator);
        int strStart = -5, strEnd = -5; // impossible position

        for (int i = 1; i < deepLocalExpression.length(); i++) {
            if ((position - i) > -1) { // it's not first number in expression
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
                if (strTemp.equals("*") || strTemp.equals("/") || strTemp.equals("+") || strTemp.equals("-") ) { // todo /- etc !! 10/-2 equals first num + sign -
                    if (strTemp.equals("-") && (
                            (Character.toString(deepLocalExpression.charAt(position)).equals("/")) ||
                    (Character.toString(deepLocalExpression.charAt(position)).equals("*")) ||
                    (Character.toString(deepLocalExpression.charAt(position)).equals("+")) ||
                    (Character.toString(deepLocalExpression.charAt(position)).equals("-")))) {
                        continue;
                    }
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
            //result = checkMinusResult(leftSideFromSign, result);
        } else {
            result = doResult(leftSideFromSign, rightSideFromSign, 0, operator);
            //result = checkMinusResult(leftSideFromSign, result);
        }

        if (result == null) {
            return null;
        }
        return deepLocalExpression.substring(0, strStart)
                + result
                + deepLocalExpression.substring(strEnd, deepLocalExpression.length());
    }

//    private String checkMinusResult(String leftSideFromSign, String result){
//        if (leftSideFromSign.charAt(0) == '-') {
//            if (result.charAt(0) == '-') {
//                return result = '-' + result;
//            }
//            return result;
//        }
//        return result;
//    }

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
                        if (Integer.parseInt(rightSideFromSign) == 0) {
                            return null;
                        }
                        if (Integer.parseInt(leftSideFromSign) % Integer.parseInt(rightSideFromSign) != 0) {
                            result = operations.div(
                                    Double.parseDouble(leftSideFromSign),
                                    Double.parseDouble(rightSideFromSign)).toString();
                            break;
                        }
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

