package com.epam.university.java.core.task006;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by Вера on 10.09.2017.
 */
public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }

        if (measurements.size() == 0) {
            return 0.0;
        }
        
        int n = measurements.size();

        double[] amperage = new double[n];
        double[] voltage = new double[n];
        //введу счетчик
        int i = 0;

        for (Measurement m : measurements) {
            amperage[i] = m.getAmperage();
            voltage[i] = m.getVoltage();
            i++;
        }

        double summaAmperageVoltage = 0;
        for (int j = 0; j < n; j++) {
            summaAmperageVoltage += amperage[j] * voltage[j];
        }

        double summaAmperage = 0;
        for (int j = 0; j < n; j++) {
            summaAmperage += amperage[j];
        }

        double summaVoltage = 0;
        for (int j = 0; j < n; j++) {
            summaVoltage += voltage[j];
        }

        double summaSquareAmperage = 0;
        for (int j = 0; j < n; j++) {
            summaSquareAmperage = summaSquareAmperage + amperage[j] * amperage[j];
        }

        double resultNumerator = n * summaAmperageVoltage - summaAmperage*summaVoltage;
        double resultDenominator = n * summaSquareAmperage - (summaAmperage)*(summaAmperage);
        double result;

        if (resultNumerator == 0) {
            result = 0.0;
        }
        else {
            result = resultNumerator / resultDenominator;
        }


//        double result2 = (summaVoltage - result * summaAmperage) / n;
//        System.out.println(summaAmperage);
//        System.out.println(summaVoltage);
//        System.out.println(summaAmperageVoltage);
//        System.out.println(summaSquareAmperage);
//        System.out.println(result);
//        System.out.println(result2);
        BigDecimal x = new BigDecimal(String.valueOf(result));
        double resultFinish = Double.parseDouble(x.setScale(3, BigDecimal.ROUND_HALF_EVEN).toString());
      //  System.out.println(resultFinish);
        return resultFinish;
    }
}
