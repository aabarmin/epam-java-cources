package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {

    /**
     * Integration algorithm implementation using Simpson's rule.
     *
     * @param left     left limit
     * @param right    right limit
     * @param function function to integrate
     * @return integration results
     */
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {

        int precision = 200_000;
        double step = (right - left) / (precision - 1);

        // 1/3 terms
        double sum = 1.0 / 3.0 * (function.apply(left) + function.apply(right));

        // 4/3 terms
        for (int i = 1; i < precision - 1; i += 2) {
            double x = left + step * i;
            sum += 4.0 / 3.0 * function.apply(x);
        }

        // 2/3 terms
        for (int i = 2; i < precision - 1; i += 2) {
            double x = left + step * i;
            sum += 2.0 / 3.0 * function.apply(x);
        }

        return sum * step;

    }

}
