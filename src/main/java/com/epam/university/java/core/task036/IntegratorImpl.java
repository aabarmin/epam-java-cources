package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double n = 1000;
        double h = (right - left) / n;
        double s = 0.5d * (function.apply(left) + function.apply(right));

        for (int i = 1; i < n; i++) {
            s = s + function.apply(left + i * h);
        }
        double d = h * s;
        return h * s;
    }
}
