package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
     public strictfp double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        if (measurements.isEmpty()) {
            return 0;
        }

        double resistance = 0;
        double amperesPerSquare = 0;
        double averageAmp = 0;
        double averageVolt = 0;

        for (Measurement measurement : measurements) {
            averageAmp += measurement.getAmperage();
            averageVolt += measurement.getVoltage();
        }
        averageAmp /= measurements.size();
        averageVolt /= measurements.size();

        for (Measurement measurement : measurements) {
            resistance += (measurement.getAmperage() - averageAmp)
                    * (measurement.getVoltage() - averageVolt);
            amperesPerSquare += (measurement.getAmperage() - averageAmp)
                    * (measurement.getAmperage() - averageAmp);
        }
        resistance /= amperesPerSquare;
        if (amperesPerSquare == 0) {
            return 0;
        }
        return ((int) (resistance * 1000)) / 100.0;
    }
}
