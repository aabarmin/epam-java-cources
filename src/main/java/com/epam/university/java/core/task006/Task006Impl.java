package com.epam.university.java.core.task006;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

/**
 * This task provide collection of measurements of voltage
 * and amperage in resistance.
 * Using Least Square method determine value of resistance.
 * Task006 implementation.
 */
public final class Task006Impl implements Task006 {

    /**
     * * Message for the case measurements not provided.
     */
    private static final String MSG_NO_ARGS = "measurements not provided";

    /**
     * Number of digits after the point.
     */
    private static final int ROUND_TO = 3;

    @Override
    public double resistance(final Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException(MSG_NO_ARGS);
        }

        double sumVoltage = 0.0;
        double sumAmperage = 0.0;
        for (Measurement m : measurements) {
            sumVoltage += m.getVoltage();
            sumAmperage += m.getAmperage();

        }
        double averageVoltage = sumVoltage / measurements.size();
        double averageAmperage = sumAmperage / measurements.size();

        double denominatorOfResistance = 0.0;
        double numeratorOfResistance = 0.0;
        for (Measurement m : measurements) {
            double v = m.getAmperage() - averageAmperage;
            denominatorOfResistance += v * v;
            numeratorOfResistance +=
                    (m.getAmperage() - averageAmperage)
                            * (m.getVoltage() - averageVoltage);
        }

        double result = 0.0;
        if (denominatorOfResistance != 0) {
            double resistance = numeratorOfResistance / denominatorOfResistance;
            result = BigDecimal.valueOf(resistance)
                    .setScale(ROUND_TO, RoundingMode.HALF_UP)
                    .doubleValue();
        }
        return result;
    }
}

