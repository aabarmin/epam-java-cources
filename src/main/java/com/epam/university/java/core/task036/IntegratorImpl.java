package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * Created by Александр on 17.10.2017.
 * Integration algorithm implementation.
 * Trapezoidal rule
 */
public class IntegratorImpl implements Integrator {
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
        double delta = 0.0001;
        double sum = 0;
        for (double i = left; i<=(right-delta); i+=delta) {
            sum += trapezoidal(i, i+delta, function);
        }

        return sum;
    }

    /**
     * Trapezoidal rule.
     * @param left      left limit
     * @param right     right limit
     * @param function  function to integrate
     * @return integration results
     */
    double trapezoidal(double left, double right, Function<Double, Double> function) {
        return (function.apply(left) + function.apply(right)) * (right - left) / 2;
    }
}
