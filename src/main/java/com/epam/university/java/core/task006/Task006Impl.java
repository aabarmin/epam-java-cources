package com.epam.university.java.core.task006;

import com.epam.university.java.core.task003.NullChecker;
import com.epam.university.java.core.task003.SimpleNullChecker;
import java.util.Collection;
import java.util.function.ToDoubleFunction;

/** Created by ilya on 06.09.17. */
public class Task006Impl implements Task006 {

    private NullChecker checker = new SimpleNullChecker();

    @Override
    public double resistance(Collection<Measurement> measurements) {
        checker.check(measurements);

        if (measurements.size() == 0) {
            return 0;
        }

        if (measurements.stream().allMatch(n -> n.getAmperage() == 0)) {
            return 0;
        }

        int length = measurements.size();

        double sumVa = adder(measurements, n -> n.getVoltage() * n.getAmperage());
        double sumA = adder(measurements, n -> n.getAmperage());
        double sumV = adder(measurements, n -> n.getVoltage());
        double sumASquare = adder(measurements, n -> Math.pow(n.getAmperage(), 2));
        double resistance = (length * sumVa - sumA * sumV)
            / (length * sumASquare - Math.pow(sumA, 2));

        return (double) (int) (resistance * 1000) / (double) 1000;
    }

    private double adder(Collection<Measurement> measurements,
        ToDoubleFunction<Measurement> lambda) {
        return measurements.stream().mapToDouble(lambda).sum();
    }
}
