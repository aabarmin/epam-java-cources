package com.epam.university.java.core.task006;

import com.epam.university.java.core.validation.Validator;

import java.util.Collection;
import java.util.stream.StreamSupport;

public class Task006Impl implements Task006 {
    private static Validator VALIDATOR = Validator.newInstance(Task006Impl.class);


    /**
     * Calculate resistance by collection of measurements using Least Square method.
     *
     * @param measurements collection of measurements
     * @return value of resistance
     * @throws IllegalArgumentException if measurements not provided
     */
    @Override
    public double resistance(Collection<Measurement> measurements) {
        VALIDATOR.assertNotNull(measurements);

        if (measurements.isEmpty()) {
            return 0.0;
        }

        double avgVoltage = 0;
        double avgAmperage = 0;
        int size = measurements.size();

        for (Measurement iter : measurements) {
            avgAmperage += iter.getAmperage();
            avgVoltage += iter.getVoltage();
        }
        avgAmperage /= size;
        avgVoltage /= size;

        double denominator = 0;
        double numerator = 0;
        for (Measurement iter : measurements) {
            double deviationAmperage = iter.getAmperage() - avgAmperage;
            double deviationVoltage = iter.getVoltage() - avgVoltage;
            numerator += deviationAmperage * deviationVoltage;

            denominator += Math.pow(iter.getAmperage() - avgAmperage, 2);
        }

        double resistance = numerator / denominator;
        return Math.round(resistance * 1000) / 1000.0;
    }
}
