package com.epam.university.java.core.task006;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.math.BigDecimal;
import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        } else if (measurements.isEmpty()) {
            return 0.0;
        } else {
            double sumAmperageVoltage = 0;
            double sumAmperage = 0;
            double sumVoltage = 0;
            long sumAmperageSqr;
            long sumAmperageSqrs = 0;
            long exps = (long) measurements.size();

            for (Measurement m : measurements) {
                sumAmperageVoltage += m.getAmperage() * m.getVoltage();
                sumAmperage += m.getAmperage();
                sumVoltage += m.getVoltage();
                sumAmperageSqrs += Math.pow(m.getAmperage(), 2);
            }

            sumAmperageSqr = (long) Math.pow(sumAmperage, 2);

            if (sumAmperage == 0) {
                return 0.0;
            } else {
                BigDecimal result = BigDecimal
                        .valueOf((exps * sumAmperageVoltage - sumAmperage * sumVoltage)
                                / (exps * sumAmperageSqrs - sumAmperageSqr));
                return result.setScale(3, BigDecimal.ROUND_DOWN).doubleValue();
            }
        }
    }
}
