package com.epam.university.java.core.task036;

import java.util.function.Function;
import java.util.stream.DoubleStream;

public class Task036Impl implements Task036 {

    @Override
    public double integrate(Function<Double, Double> function, Integrator integrator,
        double limitLeft, double limitRight) {

        final int number = 9;

        double delta = (limitRight - limitLeft) / number;

        return DoubleStream.iterate(limitLeft, d -> d + delta)
            .limit(number)
            .map(d -> integrator.integrate(d, d + delta, function))
            .sum();

    }
}
