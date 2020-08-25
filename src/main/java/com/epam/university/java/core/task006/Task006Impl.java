package com.epam.university.java.core.task006;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.stream.Collector;

/**
 * Created by Romin Nuro on 25.08.2020 16:38.
 */
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
            return 0.0;
        }
        int n = measurements.size();

        double sumOfProducts = measurements
                .stream()
                .mapToDouble(measurement -> measurement.getAmperage() * measurement.getVoltage())
                .sum();
        double amperageSum = measurements.stream()
                .mapToDouble(Measurement::getAmperage)
                .sum();
        double voltageSum = measurements.stream()
                .mapToDouble(Measurement::getVoltage)
                .sum();
        double sumOfAmperageSquares = measurements.stream()
                .mapToDouble(measurement -> Math.pow(measurement.getAmperage(), 2))
                .sum();
        if (amperageSum == 0) {
            return 0.0;
        }

        double calculationResult = (n * sumOfProducts - amperageSum * voltageSum)
                / (n * sumOfAmperageSquares - Math.pow(amperageSum, 2));

        double result = round(calculationResult, 3);

        return result;
    }

    private static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
