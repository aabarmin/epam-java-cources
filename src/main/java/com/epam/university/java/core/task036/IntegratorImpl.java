package com.epam.university.java.core.task036;

public class IntegratorImpl implements Integrator {

    @Override
    public Double apply(Double aDouble, Double aDouble2) {
        return Task036Impl.DELTA * (aDouble + aDouble2) / 2;
    }
}
