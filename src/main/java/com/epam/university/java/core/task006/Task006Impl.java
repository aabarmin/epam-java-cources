package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        double avgAmperage = 0;
        double avgVoltage = 0;
        for (Measurement measurement : measurements) {
            avgAmperage += measurement.getAmperage();
            avgVoltage += measurement.getVoltage();
        }
        avgAmperage = avgAmperage / measurements.size();
        avgVoltage = avgVoltage / measurements.size();
        double sum1 = 0;
        double sum2 = 0;
        for (Measurement measurement : measurements) {
            sum1 += (measurement.getAmperage() - avgAmperage)
                    * (measurement.getVoltage() - avgVoltage);
            sum2 += Math.pow(measurement.getAmperage() - avgAmperage,2);
        }
        double result = sum1 / sum2;


        return Math.round(result * 1000.0) / 1000.0;
    }
}
