package com.epam.university.java.core.task036;

import java.util.function.Function;
import java.util.stream.IntStream;

public class IntegratorImpl implements Integrator {

    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        final double dx = (right - left) / 1000;
        double result = IntStream.range(1, 1000)
                .mapToDouble(i -> function.apply(left + i * dx))
                .sum() + 0.5 * (function.apply(left) + function.apply(right));
        result *= dx;
        return result;
    }

}
