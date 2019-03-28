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
