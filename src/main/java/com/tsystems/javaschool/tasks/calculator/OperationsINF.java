package com.tsystems.javaschool.tasks.calculator;

public interface OperationsINF<T> {
    T sum(T a, T b);
    T diff(T a, T b);
    T mult(T a, T b);
    T div(T a, T b);
}
