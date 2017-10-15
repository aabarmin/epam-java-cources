package com.epam.university.java.core.task006;

import com.epam.university.java.core.Validator;

import java.util.Collection;

public class Task006Impl implements Task006 {
    private Validator validator = Validator.getInstance();

    @Override
    public double resistance(Collection<Measurement> measurements) {
        validator.validate(measurements);
        if (measurements.isEmpty()) {
            return 0;
        }
        double sumx = 0.0;
        double sumy = 0.0;
        for (Measurement m : measurements) {
            sumx += m.getAmperage();
            sumy += m.getVoltage();
        }

        double xbar = sumx / measurements.size();
        double ybar = sumy / measurements.size();

        double xxbar = 0.0;
        double xybar = 0.0;
        for (Measurement m : measurements) {
            xxbar += (m.getAmperage() - xbar) * (m.getAmperage() - xbar);
            xybar += (m.getAmperage() - xbar) * (m.getVoltage() - ybar);
        }

        double beta1 = xybar / xxbar;
        if (Double.isNaN(beta1)) {
            beta1 = 0;
        }
        String beta1Str = String.format("%.3f", beta1);
        String beta1StrForm = beta1Str.replaceAll(",", ".");
        return Double.parseDouble(beta1StrForm);
    }
}
