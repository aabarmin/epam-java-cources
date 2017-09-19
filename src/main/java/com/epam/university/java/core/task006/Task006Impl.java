package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException("Measurements not provided!");
        }
        double sumI = 0;
        double sumU = 0;
        double sumImultU = 0;
        double sumIsquared = 0;
        int n = measurements.size();

        for (Measurement iter : measurements) {
            sumI += iter.getAmperage();
            sumU += iter.getVoltage();
            sumImultU += iter.getAmperage() * iter.getVoltage();
            sumIsquared += Math.pow(iter.getAmperage(), 2);
        }
        //Calculate resistance using Least Square method
        double numerator = (sumI * sumU - n * sumImultU);
        double denominator = (Math.pow(sumI, 2) - n * sumIsquared);
        //Rounding up to four characters
        return Math.round((numerator / denominator) * 10000) / 10000.0;
    }
}