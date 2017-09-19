package com.epam.university.java.core.task014;

/**
 * Created by Daniil Smirnov on 19.09.2017.
 * All copy registered MF.
 */
public class VampireNumberFactoryImpl implements VampireNumberFactory {
    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {
        return new VampireNumberImpl(multiplication,first,second);
    }
}
