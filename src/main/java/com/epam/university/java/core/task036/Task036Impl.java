package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * Class implements <code>Task036</code> interface.
 */
public class Task036Impl implements Task036 {
    @Override
    public double integrate(Function<Double, Double> function, Integrator
            integrator, double limitLeft, double limitRight) {
        return integrator.integrate(limitLeft, limitRight, function);
    }
}
