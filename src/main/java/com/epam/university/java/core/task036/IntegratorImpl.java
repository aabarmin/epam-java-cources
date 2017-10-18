package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * {@inheritDoc}
 */
public class IntegratorImpl implements Integrator {
    /**
     * {@inheritDoc}
     */
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        int accuracy = 300_000;
        double step = (right - left) / (accuracy - 1);

        double sum = 1.0 / 3.0 * (function.apply(left) + function.apply(right));
        
        for (int i = 1; i < accuracy - 1; i += 2) {
            double x = left + step * i;
            sum += 4.0 / 3.0 * function.apply(x);
        }

        // 2/3 terms
        for (int i = 2; i < accuracy - 1; i += 2) {
            double x = left + step * i;
            sum += 2.0 / 3.0 * function.apply(x);
        }

        return sum * step;
    }
}
