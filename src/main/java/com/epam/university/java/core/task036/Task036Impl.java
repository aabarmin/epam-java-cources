package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * Created by Александр on 17.10.2017.
 * Numerical integration.
 */
public class Task036Impl implements Task036 {
    /**
     * Integrate given <code>function</code> using <code>integrator</code>
     * as integration algorithm in a given limits.
     *
     * @param function   function to integrate
     * @param integrator integration algorithm
     * @param limitLeft  left limit
     * @param limitRight right limit
     * @return integration results
     */
    @Override
    public double integrate(Function<Double, Double> function,
                            Integrator integrator,
                            double limitLeft, double limitRight) {
        double result = integrator.integrate(limitLeft, limitRight, function);
        return Math.round(result * 10000.0) / 10000.0;
    }
}
