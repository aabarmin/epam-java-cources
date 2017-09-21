package com.epam.university.java.core.task014;

/**
 * Factory of vampire numbers.
 */
public class VampireNumberFactoryImpl implements VampireNumberFactory {

    /**
     * Creates new vampire number instance.
     *
     * @param multiplication multiplication value
     * @param first first part value
     * @param second second part value
     * @return new instance
     */
    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {
        return new VampireNumberImpl(multiplication, first, second);
    }

}
