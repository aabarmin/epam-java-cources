package com.epam.university.java.core.task006;

import com.epam.university.java.core.util.Utils;

import java.util.Collection;

/**
 * This task provide collection of measurements of voltage and amperage in resistance. Using
 * Least Square method determine value of resistance.
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
    public double resistance(Collection<Measurement> measurements)
        throws IllegalArgumentException {
        Utils.assertNonNull(measurements);
        if (measurements.isEmpty()) {
            return 0;
        }
        double us = 0;
        double is = 0;
        double uisTimesN = 0;
        double squaredIsTimesN = 0;
        for (Measurement measurement : measurements) {
            is += measurement.getAmperage();
            us += measurement.getVoltage();
            uisTimesN += measurement.getAmperage() * measurement.getVoltage();
            squaredIsTimesN += Math.pow(measurement.getAmperage(), 2);
        }
        double isSqured = Math.pow(is, 2);
        uisTimesN *= measurements.size();
        squaredIsTimesN *= measurements.size();
        return (uisTimesN == 0 && (is == 0 || us == 0)
            && squaredIsTimesN == 0 && isSqured == 0)
            ? 0
            : (uisTimesN - us * is) / (squaredIsTimesN - isSqured);
    }

}
