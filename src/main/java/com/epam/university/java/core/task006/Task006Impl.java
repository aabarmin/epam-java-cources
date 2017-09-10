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

        double xbar = 0;
        double ybar = 0;

        for (Measurement measurement : measurements) {
            xbar += measurement.getAmperage();
            ybar += measurement.getVoltage();
        }

        xbar /= measurements.size();
        ybar /= measurements.size();

        double sxx = 0;
        double sxy = 0;

        for (Measurement measurement : measurements) {
            sxx += (measurement.getAmperage() - xbar) * (measurement.getAmperage() - xbar);
            sxy += (measurement.getAmperage() - xbar) * (measurement.getVoltage() - ybar);
        }

        double resistance = sxy / sxx;

        resistance = Double.isNaN(resistance) ? 0.0 : resistance;
        resistance = Math.round(resistance * 1000.0) / 1000.0;

        return resistance;

    }
}
