package com.epam.university.java.core.task006;

import java.math.BigDecimal;
import java.util.Collection;

public class Task006Impl implements Task006 {

    /**
     * Calculate resistance by collection of measurements using Least Square method.
     *
     * @param measurements collection of measurements
     * @return value of resistance
     * @throws IllegalArgumentException if measurements not provided
     */
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        if (measurements.isEmpty()) {
            return 0;
        }
        int n = measurements.size();
        double xySum = 0.0;
        double xSum = 0.0;
        double ySum = 0.0;
        double x2Sum = 0.0;
        double result = 0.0;
        for (Measurement mes : measurements) {
            xSum += mes.getAmperage();
            ySum += mes.getVoltage();
            xySum += mes.getAmperage() * mes.getVoltage();
            x2Sum += Math.pow(mes.getAmperage(), 2);
        }
        if (x2Sum == 0) {
            return 0;
        }
        result = (n * xySum - xSum * ySum) / (n * x2Sum - Math.pow(xSum, 2));
        int places = 3;
        int mult = (int) Math.pow(10, places);
        result *= mult;
        int res = (int) result;
        result = (double) res / mult;
        return result;
    }
}
