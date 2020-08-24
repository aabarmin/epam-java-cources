package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }

        if (measurements.size() == 0) {
            return 0.0;
        }

        double averageAmperage = 0;
        double averageVoltage = 0;
        for (Measurement measurement : measurements) {
            averageAmperage += measurement.getAmperage();
            averageVoltage += measurement.getVoltage();
        }
        averageAmperage /= measurements.size();
        averageVoltage /= measurements.size();

        double sumAmperageAndVoltage = 0;
        double sumAmperagePow = 0;
        for (Measurement measurement : measurements) {
            sumAmperageAndVoltage +=
                    (measurement.getAmperage() - averageAmperage)
                    * (measurement.getVoltage() - averageVoltage);

            sumAmperagePow += Math.pow(
                    (measurement.getAmperage() - averageAmperage), 2);
        }

        Double resistance = sumAmperageAndVoltage / sumAmperagePow;
        if (resistance.isNaN()) {
            resistance = 0.0;
        }
        return Math.round(resistance * 1000) / 1000.0;
    }
}
