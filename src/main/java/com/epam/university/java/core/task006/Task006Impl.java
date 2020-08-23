package com.epam.university.java.core.task006;

import java.util.ArrayList;
import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }

        class Parameter {
            private double t;
            private double y;
            private double t2;
            private double ty;

            private Parameter(Measurement measurement) {
                this.t = measurement.getAmperage();
                this.y = measurement.getVoltage();
                this.t2 = measurement.getAmperage() * measurement.getAmperage();
                this.ty = measurement.getAmperage() * measurement.getVoltage();
            }
        }

        ArrayList<Parameter> parameters = new ArrayList<>();
        for (Measurement measurement : measurements) {
            parameters.add(new Parameter(measurement));
        }

        //an + b∑t = ∑y
        //a∑t + b∑t2 = ∑y*t

        double an = parameters.size();
        double sumT = 0;
        double sumY = 0;
        double sumT2 = 0;
        double sumTy = 0;

        for (Parameter parameter : parameters) {
            sumT += parameter.t;
            sumY += parameter.y;

            sumT2 += parameter.t2;
            sumTy += parameter.ty;
        }

        //----Сократим---///
        double sumTNew = sumT / an;
        double sumYNew = sumY / an;

        double sumT2New = sumT2 / sumT;
        double sumTyNew = sumTy / sumT;

        //---Перенесем и посчитает---//
        double sumB = sumTNew - sumT2New;
        double sumValue = sumYNew - sumTyNew;
        int format = (int) ((sumValue / sumB) * 1000);
        return ((double) format / 1000);
    }
}
