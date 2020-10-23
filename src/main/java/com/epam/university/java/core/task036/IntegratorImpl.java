package com.epam.university.java.core.task036;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.function.Function;

public class IntegratorImpl implements Integrator {

    public static final double INCREMENT = 1E-6;

    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double area = 0;
        double modifier = 1;
        if (left > right) {
            double tmp = left;
            left = right;
            right = tmp;
            modifier = -1;
        }
        for (double i = left + INCREMENT; i < right; i += INCREMENT) {
            double dFromLeft = i - left;
            area += (INCREMENT / 2) * function.apply(left + dFromLeft)
                    + function.apply(left + dFromLeft - INCREMENT);
        }
        area /= 10;
        area = Math.round(area);


        int result = (int) area;
        return Math.round(result) / 100000.0 * modifier;
    }
}
