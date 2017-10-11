package com.epam.university.java.core.task036;

import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Integration algorithm implementation.
 */
public class IntegratorImpl implements Integrator {

    private static final int partitions = 1_000_000;

    /**
     * Trapezoidal integration algorithm implementation.
     * @param left left limit
     * @param right right limit
     * @param function function to integrate
     * @return integration results
     */
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        final double stepSize = (right - left) / partitions;
        double sum = (function.apply(left) + function.apply(right)) / 2;

        sum += IntStream.range(1, partitions)
            .parallel()
            .mapToObj(i -> function.apply(left + i * stepSize))
            .reduce(0.0, Double::sum);

        return sum * stepSize;
    }

}
