package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {
    @Override
    public double integrate(double left, double right,
                            Function<Double, Double> function) {
        return (right - left) / 6
                * (function.apply(left)
                + 4 * function.apply((left + right) / 2)
                + function.apply(right));
    }
}
