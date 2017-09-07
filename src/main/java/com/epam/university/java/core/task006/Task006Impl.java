package com.epam.university.java.core.task006;

import java.util.Collection;
import java.util.function.ToDoubleFunction;

import com.epam.university.java.core.task003.NullChecker;
import com.epam.university.java.core.task003.SimpleNullChecker;
/**
 * Created by ilya on 06.09.17.
 */
public class Task006Impl implements Task006 {
    private Collection<Measurement> measurements;
    private NullChecker checker = new SimpleNullChecker();

    @Override
    public double resistance(Collection<Measurement> measurements) {
        checker.check(measurements);

        this.measurements = measurements;

        if(measurements.size()==0){
            return 0;
        }

        if(measurements.stream().allMatch(n -> n.getAmperage() == 0)){
            return 0;
        }

        int length = measurements.size();

        double resistance = (length * calculation(n -> n.getVoltage() * n.getAmperage())
                            - calculation(n -> n.getAmperage())
                            * calculation(n -> n.getVoltage())
                            )/(
                                    length * calculation(n -> Math.pow(n.getAmperage(),2))
                                    - Math.pow(calculation(n -> n.getAmperage()),2)
                            );

        return (double)(int)(resistance*1000)/(double)1000;
    }

    private double calculation(ToDoubleFunction<Measurement> lambda){
        return measurements.stream()
                .mapToDouble(lambda)
                .sum();
    }
}
