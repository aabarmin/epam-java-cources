package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {
    // more value - more accuracy
    private final double partsNumber = 1000000;

    /**
     * Integration algorithm implementation.
     *
     * @param left     left limit
     * @param right    right limit
     * @param function function to integrate
     * @return integration results
     */
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double result = 0;

        //calculating integral by "left rectangle method"
        double h = (right - left) / partsNumber;
        for (double i = left + h; i <= right; i += h) {
            result += h * function.apply(i);
        }

        return result;
    }
}
