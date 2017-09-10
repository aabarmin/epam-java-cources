package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        double averageVoltage = measurements.stream()
                .mapToDouble(Measurement::getVoltage)
                .sum() / measurements
                .size();
        double averageAmperage = measurements.stream()
                .mapToDouble(Measurement::getAmperage)
                .sum() / measurements
                .size();
        double denominatorOfResistance = measurements.stream()
                .mapToDouble(Measurement::getAmperage)
                .map((n) -> n - averageAmperage)
                .map((n) -> n * n)
                .sum();
        double numeratorOfResistance = 0;
        for (Measurement current:measurements) {
            numeratorOfResistance += (current.getAmperage() - averageAmperage)
                    * (current.getVoltage() - averageVoltage);
        }
        if (denominatorOfResistance == 0) {
            return 0.0;
        }
        double resistance = numeratorOfResistance / denominatorOfResistance;
        return Math.round(resistance * 1000) / 1000.0;
    }
}
