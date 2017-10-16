package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * Created by Вера on 14.10.2017.
 */
public class Task036Impl implements Task036 {
    @Override
    public double integrate(Function<Double, Double> function,
                            Integrator integrator, double limitLeft, double limitRight) {

        Integrator integrator1 = integrator;

        // делаю составную квадратурную формулу

        int n = 20;
        double interval = (limitRight - limitLeft) / n;
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += integrator1.integrate(limitLeft + i * interval,
                    limitLeft + i * interval + interval,function);
        }

        return result;
    }
}
