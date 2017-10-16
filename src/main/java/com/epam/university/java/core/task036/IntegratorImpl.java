package com.epam.university.java.core.task036;

import java.util.function.Function;
import java.util.stream.IntStream;

public class IntegratorImpl implements Integrator {
    private static final int nSteps = 1_000_000;

    /*
     * Trapezoidal integration algorithm implementation.
     *
     * classic formula : s = sum from 1 to nSteps of stepSize * (f(i) + f(i+2)) / 2
     * can be changed to: s = stepSize * (f(1) + f(nSteps) / 2 + sum(f(2)...f(nSteps-1))).
     *
     * @param left left limit
     * @param right right limit
     * @param function function to integrate
     * @return integration results
      */
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        final double stepSize = (right - left) / nSteps;
        double sum = (function.apply(left) + function.apply(right)) / 2;
        sum += IntStream.range(1, nSteps)
                .parallel()
                .mapToDouble(i -> function.apply(left + i * stepSize))
                .reduce(0.0, Double::sum);
        return sum * stepSize;
    }
}
