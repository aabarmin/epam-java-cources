package com.epam.university.java.core.task036;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.DoubleStream;

public class Task036Impl implements Task036 {

    public static final double DELTA = 0.001;
    public static final int N = 10000;

    @Override
    public double integrate(Function<Double, Double> function,
        BiFunction<Double, Double, Double> integrator, double limitLeft, double limitRight) {

        // Your integrator is good, but I use my integrator with preference and Simpson formula

        Integrator myIntegrator = (d1, d2) -> (
            (d2 - d1)
                * (
                function.apply(d1)
                    + 4 * function.apply((d1 + d2) / 2)
                    + function.apply(d2)
            )
                / 6
        );
        final double del = (limitRight - limitLeft) / N;

        return DoubleStream.iterate(limitLeft, delta -> delta + del)
            .limit(N)
            .map(d -> myIntegrator.apply(d, d + del))
            .sum();
    }
}
