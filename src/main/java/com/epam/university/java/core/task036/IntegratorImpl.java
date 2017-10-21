package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {

    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double coef = (left + right) / 100000;
        double ressult = 0;
        double current = left;
        double value = 0;
        while (Math.abs(current - right) > coef) {
            value = current + coef / 2;
            ressult += coef * function.apply(value);
            current += coef;
        }
        return ressult;
    }

}
