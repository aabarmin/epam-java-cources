package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {
    double delta = 0.0001;

    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double sum = 0;

        for (double i = left; i < right - delta; i += delta) {
            double a = function.apply(i);
            double b = function.apply(i + delta);
            sum += (a + b) / 2 * delta;
        }
        return sum;
    }
}
