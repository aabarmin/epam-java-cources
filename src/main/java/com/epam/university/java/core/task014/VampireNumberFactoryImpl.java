package com.epam.university.java.core.task014;

public class VampireNumberFactoryImpl implements VampireNumberFactory {
    /**
     * Create new vampire number instance.
     *
     * @param multiplication multiplication value
     * @param first          first part value
     * @param second         second part value
     * @return new instance
     */
    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {
        return new VampireNumberImpl(multiplication, first, second);
    }
}
