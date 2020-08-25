package com.epam.university.java.core.task006;

import java.text.DecimalFormat;
import java.util.ArrayList;
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

        ArrayList<Measurement> list = new ArrayList<>(measurements);

        double sum = 0;
        for (Measurement measurement : list) {
            sum += measurement.getAmperage() * measurement.getVoltage();
        }
        double sumA = 0;
        for (Measurement measurement : list) {
            sumA += measurement.getAmperage();
        }
        double sumV = 0;
        for (Measurement measurement : list) {
            sumV += measurement.getVoltage();
        }
        double sumOfAmpSq = 0;
        for (Measurement measurement : list) {
            sumOfAmpSq += Math.pow(measurement.getAmperage(), 2);
        }

        double result = (list.size() * sum - sumA * sumV) / (list.size() * sumOfAmpSq - Math.pow(sumA, 2));

        if (sumA == 0) {
            return 0.0;
        }

        return Math.floor(result * 1000) / 1000;
    }
}
