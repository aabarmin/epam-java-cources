package com.epam.university.java.core.task014;

/**
 * Implementation class for VampireNumberFactory.
 *
 * @author Sergei Titov
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
