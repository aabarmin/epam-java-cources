package com.epam.university.java.core.task006;

import java.util.Collection;

/**
 * Created by Doomsday Device on 23.09.2017.
 */
public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }

        if (measurements.isEmpty()) {
            return 0;
        }

        double sumAmperage = 0;
        double sumVoltage = 0;
        double sumMultiplication = 0;
        double sumSquareAmperage = 0;
        double sumSquareVoltage = 0;

        double averageAmperage = 0;
        double averageVoltage = 0;


        for (Measurement measurement : measurements) {
            double amperage = measurement.getAmperage();
            double voltage = measurement.getVoltage();

            sumAmperage += amperage;
            sumVoltage += voltage;
            sumMultiplication += amperage * voltage;
            sumSquareAmperage += Math.pow(amperage, 2);
            sumSquareVoltage += Math.pow(voltage, 2);
        }

        averageAmperage = sumAmperage / measurements.size();
        averageVoltage = sumVoltage / measurements.size();

        int n = measurements.size();
        double b = ((n * sumMultiplication) - (sumAmperage * sumVoltage))
                / ((n * sumSquareAmperage) - Math.pow(sumAmperage, 2));

        double result = 0;

        result = Math.round(b * 1000);
        result /= 1000;

        return result;
    }
}
