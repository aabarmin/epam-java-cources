package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {
    private final double numOfIterations = 10000;
    private double start;
    private double end;
    private double delta;
    private double result;

    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        if (function == null) {
            throw new IllegalArgumentException();
        }

        delta = (right - left) / numOfIterations;
        result = 0;

        for (int i = 0; i < numOfIterations; i++) {
            start = left + delta * i;
            end = start + delta;
            result += ((function.apply(start) + function.apply(end)) / 2) * delta;
        }

        return result;
    }
}
