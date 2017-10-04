package com.epam.university.java.core.task014;

/**
 * Class factory for Vampire number.
 */
public class VampireNumberFactoryImpl implements VampireNumberFactory {
    @Override
    public VampireNumber newInstance(int multiplication, int first, int
            second) {
        return new VampireNumberImpl(multiplication, first, second);
    }
}
