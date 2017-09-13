package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {

    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }

        if (measurements.isEmpty()) {
            return 0.0;
        }

        double ea = 0;
        double ev = 0;
        double eav = 0;
        double eas = 0;

        for (double amperage : measurements.stream()
                .mapToDouble(Measurement::getAmperage)
                .toArray()) {

            ea += amperage;
        }
        for (double voltage : measurements.stream()
                .mapToDouble(Measurement::getVoltage)
                .toArray()) {

            ev += voltage;
        }
        for (Measurement m : measurements) {
            eav += m.getAmperage() * m.getVoltage();
            eas += Math.pow(m.getAmperage(),2);
        }
        int elements = measurements.size();

        double res = (elements * eav - ea * ev) / (elements * eas - Math.pow(ea,2));

        return Math.round(res * 1000.0) / 1000.0;
    }
}
