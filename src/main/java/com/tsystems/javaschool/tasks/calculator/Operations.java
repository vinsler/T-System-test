package com.tsystems.javaschool.tasks.calculator;

public class Operations implements OperationsINF<Double> {

    public Double sum(Double a, Double b) {
        return a + b;
    }

    public Double diff(Double a, Double b) {
        return a - b;
    }

    public Double mult(Double a, Double b) {
        return a * b;
    }

    public Double div(Double a, Double b) {
        if (b != 0) {
            return a / b;
        }
        return null;
    }
}
