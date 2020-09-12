package com.epam.university.java.core.task036;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

/**
 * Created by Romin Nuro on 12.09.2020 14:48.
 */
public class Task036Impl implements Task036 {
    private final Integrator integrator;

    public Task036Impl() {
        this.integrator = new IntegratorImpl();
    }

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
                            Integrator integrator, double limitLeft,
                            double limitRight) {
        double fullResult = integrator.integrate(limitLeft, limitRight, function);
        BigDecimal result = new BigDecimal(fullResult);
        result = result.setScale(4, RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}
