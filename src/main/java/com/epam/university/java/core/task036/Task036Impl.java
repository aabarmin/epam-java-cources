package com.epam.university.java.core.task036;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task036Impl implements Task036 {
    @Override
    public double integrate(Function<Double, Double> function,
                            Integrator integrator, double limitLeft, double limitRight) {
        double integral = 0;
        double step = (limitRight - limitLeft) / 40000;
        double currentPoint = limitLeft;
        while (currentPoint < limitRight) {
            double nextPoint = currentPoint + step;
            integral += integrator.integrate(currentPoint, nextPoint, function);
            currentPoint = nextPoint;
        }
        return integral;
    }
}
