package com.tsystems.javaschool.tasks.pyramid;

import java.util.List;

public class Validation {
    private boolean validate;
    private static int countRows;

    public boolean checkError(List<Integer> inputNumbers){
        if (inputNumbers.contains(null)){
            return false;
        }
        if (inputNumbers.isEmpty()) {
            return false;
        }

        int validateNumeral = 1; // validate pyramid rows by tree
        countRows++; // if dont empty or null then >= 1;
            for (int i = 1; i <= inputNumbers.size(); i++) {
                validateNumeral += i + 1;
                countRows++;
                if (inputNumbers.size() > 2147483639) {
                    return false;
                }
                if (validateNumeral >= inputNumbers.size()) {
                    if (validateNumeral == inputNumbers.size()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        return true;
    }

    public Validation(List<Integer> inputNumbers) {
        if (checkError(inputNumbers)) {
            validate = true;
        }
    }

    public int getCountRows(){
        return countRows;
    }

    public boolean isValidate() {
        return validate;
    }
}