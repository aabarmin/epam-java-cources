package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * Implementation class for Integrator.
 *
 * @author Sergei Titov
 */
public class IntegratorImpl implements Integrator {

    /**
     * {@inheritDoc}
     */
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {

        double dX = 0.000001;
        double integral = 0.0;
        for (double x = left; x <= right; x += dX) {
            integral += function.apply(x) * dX;
        }

        return integral;
    }
}
