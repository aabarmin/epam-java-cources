package com.epam.university.java.core.task014;

/**
 * Created by ilya on 16.09.17.
 */
public class VampireNumberFactoryImpl implements VampireNumberFactory {

    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {
        return new VampireNumberImpl(first, second, multiplication);
    }
}
