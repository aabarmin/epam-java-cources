package com.epam.university.java.core.task006;

import com.epam.university.java.core.validation.Validator;

import java.util.Collection;
import java.util.stream.StreamSupport;

/**
 * Created by Александр on 06.09.2017.
 */
public class Task006Impl implements Task006 {
    private static Validator VALIDATOR = Validator.newInstance(Task006Impl.class);


    /**
     * Calculate resistance by collection of measurements using Least Square method.
     *
     * @param measurements collection of measurements
     * @return value of resistance
     * @throws IllegalArgumentException if measurements not provided
     */
    @Override
    public double resistance(Collection<Measurement> measurements) {
        VALIDATOR.assertNotNull(measurements);

        //Double num = 0;
        //measurements.stream().forEach(m -> num += (m.getAmperage()*m.getVoltage()));

        return 0;
    }
}
