package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * Author Dmitry Novikov 21-Sep-20.
 */
public class IntegratorImpl implements Integrator {
    public static final int STEPS = 300;

    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double result = 0;
        double delta = (right - left) / STEPS;
        for (int i = 0; i < STEPS; i++) {
            double start = left + delta * i;
            double finish = start + delta;
            result += ((function.apply(start) + function.apply(finish)) / 2) * delta;
        }
        return result;
    }
}
