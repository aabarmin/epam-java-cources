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

        double amperage = 0;
        double voltage = 0;
        for (Measurement measurement : measurements) {
            amperage += measurement.getAmperage();
            voltage += measurement.getVoltage();
        }
        amperage /= measurements.size();
        voltage /= measurements.size();

        double sumAmperageAndVoltage = 0;
        double sumAmperagePow = 0;
        for (Measurement measurement : measurements) {
            sumAmperageAndVoltage +=
                    (measurement.getAmperage() - amperage)
                            * (measurement.getVoltage() - voltage);

            sumAmperagePow += Math.pow(
                    (measurement.getAmperage() - amperage), 2);
        }

        Double resistance = sumAmperageAndVoltage / sumAmperagePow;
        if (resistance.isNaN()) {
            resistance = 0.0;
        }
        return Math.round(resistance * 1000) / 1000.0;
    }

}
