package com.tsystems.javaschool.tasks.pyramid;

import java.util.List;

public class Validation {
    private boolean validate;

    public boolean checkError(List<Integer> inputNumbers){
        if (inputNumbers.contains(null)){
            return false;
        }
        if (inputNumbers.isEmpty()) {
            return false;
        }

        int validateNumeral = 1; // validate pyramid rows by tree
            for (int i = 1; i <= inputNumbers.size(); i++) {
                validateNumeral += i + 1;
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

    public boolean isValidate() {
        return validate;
    }
}