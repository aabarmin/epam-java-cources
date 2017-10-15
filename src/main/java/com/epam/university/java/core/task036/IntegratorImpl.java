package com.epam.university.java.core.task036;

import java.util.function.Function;

//Implementation of the Simpson's method for numerical integration.
public class IntegratorImpl implements Integrator {
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        final int numSegments = 200000;
        double evenSum = 0;
        double oddSum = 0;
        double step = (right - left) / (numSegments - 1);
        for (int i = 2; i < (numSegments - 1); i += 2) {
            double evenX = left + i * step;
            double oddX = left + (i - 1) * step;

            evenSum += function.apply(evenX);
            oddSum += function.apply(oddX);
        }
        return (step / 3)
                * (function.apply(left) + function.apply(right) + 2 * evenSum + 4 * oddSum);
    }
}