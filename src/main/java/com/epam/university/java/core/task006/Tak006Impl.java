package com.epam.university.java.core.task006;

import java.util.Collection;
import java.math.RoundingMode;

public class Tak006Impl implements Task006 {

    @Override
    public double resistance(Collection<Measurement> measurements) {

        if (measurements == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }

        double sumAmperage = 0;
        double sumVoltage = 0;
        double sumSquareAmperage = 0;
        double sumComposition = 0;

        for (Measurement m : measurements) {
            sumAmperage += m.getAmperage();
            sumVoltage += m.getVoltage();
            sumSquareAmperage += Math.pow(m.getAmperage(), 2);
            sumComposition += m.getAmperage() * m.getVoltage();
        }

        sumAmperage = sumAmperage / measurements.size();
        sumVoltage = sumVoltage / measurements.size();

        if (sumAmperage == 0) {
            return 0.0;
        }

        double res = ((sumComposition / measurements.size()) - (sumAmperage * sumVoltage))
                /
                ((sumSquareAmperage / measurements.size()) - (Math.pow(sumAmperage, 2)));

        res = Math.round(res * 1000);
        return res / 1000;
    }
}
