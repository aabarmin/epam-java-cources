package com.epam.university.java.core.task014;

/**
 * Author Dmitry Novikov 05-Sep-20.
 */
public class VampireNumberFactoryImpl implements VampireNumberFactory {
    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {
        return new VampireNumberImpl(multiplication, first, second);
    }
}
