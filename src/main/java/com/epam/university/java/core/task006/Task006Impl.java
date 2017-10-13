package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        // Check for null
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        
        // Check for empty collection
        if (measurements.isEmpty()) {
            return 0.0;
        }

        double sumAmperage = 0;
        double sumVoltage = 0;
        double sumAmperageMultiplyVoltage = 0;
        double sumAmperageSquare = 0;

        // Necessary summation for the result formula
        for (Measurement measurement : measurements) {
            sumAmperage += measurement.getAmperage();
            sumVoltage += measurement.getVoltage();
            sumAmperageMultiplyVoltage += measurement.getAmperage() * measurement.getVoltage();
            sumAmperageSquare += Math.pow(measurement.getAmperage(), 2);
        }

        int size = measurements.size();
        
        // Result calculation
        double result = ((size * sumAmperageMultiplyVoltage) - sumAmperage * sumVoltage);
        result /= (size * sumAmperageSquare - Math.pow(sumAmperage, 2));
        
        // Rounding the result to 3 digits and return
        return Math.round(result * 1000.0) / 1000.0;
    }
}
