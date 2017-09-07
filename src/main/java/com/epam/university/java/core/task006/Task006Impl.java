package com.epam.university.java.core.task006;

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

        if (measurements.size() == 0) {
            return 0.0;
        }

        double xBar = 0;
        double yBar = 0;

        for (Measurement measurement : measurements) {
            xBar += measurement.getAmperage();
            yBar += measurement.getVoltage();
        }

        xBar /= measurements.size();
        yBar /= measurements.size();

        double sXX = 0;
        double sXY = 0;

        for (Measurement measurement : measurements) {
            sXX += (measurement.getAmperage() - xBar) * (measurement.getAmperage() - xBar);
            sXY += (measurement.getAmperage() - xBar) * (measurement.getVoltage() - yBar);
        }

         double resistance = sXY / sXX;

        resistance = Double.isNaN(resistance) ? 0.0 : resistance;
        resistance = Math.round(resistance * 1000.0) / 1000.0;

        return resistance;

    }
}
