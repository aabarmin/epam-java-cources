package com.epam.university.java.core.task006;

import com.epam.university.java.core.ChecksHelper;

import java.util.Collection;

/**
 * implementation class for Task006.
 *
 * @author Sergei Titov
 */
public class Task006Impl implements Task006 {

    /**
     * calculates resistances accordingly to Amperage-Voltage pairs.
     *
     * @param measurements collection of measurements
     *
     * @returns a resistance value
     *
     * @throws IllegalArgumentException if measurements is null
     */
    @Override
    public double resistance(Collection<Measurement> measurements) {

        // check for arg consistency
        ChecksHelper.checkForNull(measurements);
        if (0 == measurements.size())
            return 0.0;

        double sumUxI = 0;
        double sumIxI = 0;
        double sumU = 0;
        double sumI = 0;
        int n = measurements.size();

        // Z = n * Σ(I²) - (ΣI)²
        // (n * Σ(U*I) – Σ(U)*Σ(I)) / Z;
        for (Measurement measure : measurements) {
            double voltage = measure.getVoltage();
            double amperage = measure.getAmperage();

            sumUxI += (voltage * amperage);
            sumIxI += (amperage * amperage);
            sumU += voltage;
            sumI += amperage;
        }
        double Z = (n * sumIxI) - (sumI * sumI);

        if (0 == Z)
            return 0;

        double retVal = ((n * sumUxI) - (sumU * sumI)) / Z;
        return ((float)((int)(retVal * 10000))) / 10000; // take only 4 digits after point
    }
}
