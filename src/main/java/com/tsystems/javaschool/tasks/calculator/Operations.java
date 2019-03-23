package com.tsystems.javaschool.tasks.calculator;

public class Operations implements OperationsINF<Double> {

    public Double sum(Double a, Double b) {
        return a + b;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public Double diff(Double a, Double b) {
        return a - b;
    }

    public int diff(int a, int b) {
        return a - b;
    }


    public Double mult(Double a, Double b) {
        return a * b;
    }

    public int mult(int a, int b) {
        return a * b;
    }


    public Double div(Double a, Double b) {
        if (b != 0) {
            return a / b;
        }
        return null;
    }

    public Integer div(Integer a, Integer b) {
        if (b != 0) {
            return a / b;
        }
        return null;
    }
}
