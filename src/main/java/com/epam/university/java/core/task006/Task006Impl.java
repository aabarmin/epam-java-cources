package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements != null) {
            // Calc resistance

            double avgAmper = 0.0;
            double avgVolt = 0.0;

            for (Measurement measure : measurements) {
                avgAmper += measure.getAmperage();
                avgVolt += measure.getVoltage();
            }
            avgAmper /= measurements.size();
            avgVolt /= measurements.size();

            double trueAmper = 0.0;
            double trueVolt = 0.0;

            for (Measurement measure : measurements) {
                trueAmper += (measure.getVoltage() - avgVolt) * (measure.getAmperage() - avgAmper);
                trueVolt += Math.pow(measure.getAmperage() - avgAmper, 2);
            }
            int result = (int) ((trueAmper / trueVolt) * 1000);

            return  result / 1000.0;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
