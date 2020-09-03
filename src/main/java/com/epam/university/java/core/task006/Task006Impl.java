package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    /**
     * Calculate resistance by collection of measurements using Least Square method.
     * @param measurements collection of measurements
     * @return value of resistance
     * @throws IllegalArgumentException if measurements not provided
     */

    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            System.out.println("Error in measurement");
            throw new IllegalArgumentException();
        } else if (measurements.size() == 0) {
            return 0d;
        }
        double numerator = 0d;
        double denominator = 0d;
        for (Measurement currentMeasurement:
             measurements) {
            numerator += currentMeasurement.getAmperage() * currentMeasurement.getVoltage();
            denominator += Math.sqrt(currentMeasurement.getAmperage());
        }
        return numerator / denominator;
    }
}
