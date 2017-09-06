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

        // Compute averages.
        double xbar = 0;
        double ybar = 0;

        for (Measurement measurement : measurements) {
            xbar += measurement.getAmperage();
            ybar += measurement.getVoltage();
        }

        xbar /= measurements.size();
        ybar /= measurements.size();

        // Compute Sxx and Sxy
        double Sxx = 0;
        double Sxy = 0;

        for (Measurement measurement : measurements) {
            Sxx += (measurement.getAmperage() - xbar) * (measurement.getAmperage() - xbar);
            Sxy += (measurement.getAmperage() - xbar) * (measurement.getVoltage() - ybar);
        }

        // Hence find maximum likelihood estimators.
        double a = Sxy / Sxx;

        a = Double.isNaN(a) ? 0.0 : a;
        a = Math.round(a * 1000.0) / 1000.0;

        return a;

    }
}
