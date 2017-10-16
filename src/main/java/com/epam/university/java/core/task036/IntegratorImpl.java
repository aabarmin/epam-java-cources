package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {

    private final double partsNumber = 1000000;

    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double result = 0;

        double h = (right - left) / partsNumber;
        for (double i = left + h; i <= right; i += h) {
            result += h * function.apply(i);
        }

        return result;
    }
}
