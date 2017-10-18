package com.epam.university.java.core.task006;

import java.util.Collection;

/**
 * Created by Vadim on 22.09.2017.
 */
public class Task006Impl implements Task006 {

    private double round(double number) {
        int pow = 10;
        double tmp = 0;
        for (int i = 1; i < 3; i++) {
            pow *= 10;
            tmp = number * pow;
        }
        return (double) (int) ((tmp - (int) tmp) >= 0.5 ? tmp + 1 : tmp) / pow;
    }

    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }

        // to use Least Square Method I need to create a lot of "sum's"

        double sum1 = 0;
        for (Measurement element: measurements) {
            sum1 += element.getVoltage() * element.getAmperage();
        }

        double sum2 = 0;
        for (Measurement element: measurements) {
            sum2 += element.getAmperage();
        }


        double sum3 = 0;
        for (Measurement element: measurements) {
            sum3 += element.getVoltage();
        }

        double sum4 = 0;
        for (Measurement element: measurements) {
            sum4 += Math.pow(element.getAmperage(), 2);
        }
        double sum5 = 0;
        for (Measurement element: measurements) {
            sum5 += element.getAmperage();
        }
        int n = measurements.size();
        double resist; // It's resistance
        resist = (n * sum1 - sum2 * sum3) / (n * sum4 - Math.pow(sum5, 2));

        if (sum2 == 0) {
            resist = 0;
        }

        return round(resist);
    }
}
