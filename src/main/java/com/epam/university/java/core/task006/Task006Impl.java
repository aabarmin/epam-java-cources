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

        double avVoltage = 0.0;
        double avAmperage = 0.0;
        for(Measurement m : measurements){
            avAmperage += m.getAmperage();
            avVoltage += m.getVoltage();
        }
        avAmperage = avAmperage / measurements.size();
        avVoltage = avVoltage / measurements.size();

        double result = 0.0;
        double numerator = 0.0;
        double denominator = 0.0;

        for (Measurement m : measurements) {
            numerator += (m.getAmperage() - avAmperage) * (m.getVoltage() - avVoltage);
            denominator += Math.pow(m.getAmperage() - avAmperage, 2);
        }

        result = Math.round((numerator / denominator) * 1000) / 1000.0;

        return result;
    }
}
