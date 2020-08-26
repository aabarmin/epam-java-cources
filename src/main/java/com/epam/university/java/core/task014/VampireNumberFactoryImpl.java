package com.epam.university.java.core.task014;

/**
 * Created by Romin Nuro on 26.08.2020 15:21.
 */
public class VampireNumberFactoryImpl implements VampireNumberFactory {
    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {
        return new VampireNumberImpl(first, second);
    }
}
