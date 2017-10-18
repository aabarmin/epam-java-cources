package com.epam.university.java.core.task014;

/**
 * {@inheritDoc}
 */
public class VampireNumberFactoryImpl implements VampireNumberFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {
        return new VampireNumberImpl(multiplication, first, second);
    }
}
