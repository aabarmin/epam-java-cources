package com.epam.university.java.core.task006;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;

/**
 * Some text.
 */
public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        if (measurements.isEmpty()) {
            return 0.0;
        }

        double amperageSumm = 0;
        double voltageSumm = 0;
        double amperageVoltageMultiplicationSumm = 0;
        double amperageSquaredSumm = 0;
        double resistance = 0;
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.DOWN);

        for (Measurement measurement : measurements
             ) {
            amperageSumm += measurement.getAmperage();
            voltageSumm += measurement.getVoltage();
            amperageSquaredSumm += Math.pow(measurement.getAmperage(),2);
            amperageVoltageMultiplicationSumm += measurement.getAmperage()
                    * measurement.getVoltage();

        }

        double dividend = measurements.size() * amperageVoltageMultiplicationSumm
                - amperageSumm * voltageSumm;
        double divider = measurements.size() * amperageSquaredSumm
                - Math.pow(amperageSumm,2);

        resistance = dividend / divider;
        Double result =
                Double.valueOf(df.format(resistance));
        if (result.isNaN()) {
            return 0.0;
        }

        System.out.println(result);

        return result;
    }
}
