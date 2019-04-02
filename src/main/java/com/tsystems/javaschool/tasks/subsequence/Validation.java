package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Validation {
    private boolean validate;

    public boolean checkError(List x, List y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException();
        }
        if (!x.isEmpty() & y.isEmpty()) {
            return false;
        }
        return true;
    }

    public Validation(List x, List y) {
        if (checkError(x, y)) {
            validate = true;
        }
    }

    public boolean isValidate() {
        return validate;
    }
}