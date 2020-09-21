package com.epam.university.java.core.task036;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

/**
 * Author Dmitry Novikov 21-Sep-20.
 */
public class Task036Impl implements Task036 {

    private Integrator integrator;

    public Task036Impl() {
        this.integrator = new IntegratorImpl();
    }

    @Override
    public double integrate(Function<Double, Double> function, Integrator integrator,
                            double limitLeft, double limitRight) {
        double result = integrator.integrate(limitLeft, limitRight, function);
        BigDecimal roundedResult = new BigDecimal(result);
        roundedResult = roundedResult.setScale(4, RoundingMode.HALF_UP);
        return roundedResult.doubleValue();
    }
}
