package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * Integration algorithm implementation.
 */
@FunctionalInterface
public interface Integrator {
    /**
     * Integration algorithm implementation.
     * @param left left limit
     * @param right right limit
     * @param function function to integrate
     * @return integration results
     */
    double integrate(double left, double right, Function<Double, Double> function);
}
