package com.epam.university.java.core.task006;

import com.epam.university.java.core.utils.Validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        Validator.validateNotNull(measurements,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (measurements.isEmpty()) {
            return 0;
        }
        ArrayList<Measurement> measurementArrayList =
                (ArrayList<Measurement>) measurements;
        double averageAmperage = average(measurements, "amperage");
        double averageVoltage = average(measurements, "voltage");
        double covariance = 0;
        double variance = 0;
        for (int i = 0; i < measurementArrayList.size(); i++) {
            covariance += (measurementArrayList.get(i).getAmperage()
                    - averageAmperage)
                    * (measurementArrayList.get(i).getVoltage()
                    - averageVoltage);
            variance += Math.pow((measurementArrayList.get(i).getAmperage()
                    - averageAmperage), 2);
        }
        if (variance == 0) {
            return 0;
        }
        return new BigDecimal(covariance / variance)
                .setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Calculates the average value from given Collection of Measurements.
     *
     * @param measurements    Collection of Measurements
     * @param measurementName name of Measurement's value to get: "amperage"
     *                        or "voltage"
     * @return double
     * @throws NoSuchMethodException     if a particular method cannot be found
     * @throws ClassNotFoundException    if no definition for the class with
     *                                   the specified name could be found
     * @throws IllegalAccessException    if the currently
     *                                   executing method does not have
     *                                   access to the definition of
     *                                   the specified class, field, method
     *                                   or constructor
     * @throws InvocationTargetException an exception thrown by an invoked
     *                                   method or constructor
     */
    public double average(Collection<Measurement> measurements,
                          String measurementName) {
        Validator.validateNotNull(measurements, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        ArrayList<Measurement> measurementArrayList =
                (ArrayList<Measurement>) measurements;
        double tempVariable = 0;
        try {
            Method getMethod = Class.forName(Measurement.class.getName())
                    .getDeclaredMethod("get" + measurementName
                            .substring(0, 1).toUpperCase()
                            + measurementName.substring(1));
            for (int i = 0; i < measurements.size(); i++) {
                tempVariable += (double) getMethod.invoke(measurementArrayList
                        .get(i));
            }
        } catch (NoSuchMethodException | ClassNotFoundException
                | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return tempVariable / measurementArrayList.size();
    }
}