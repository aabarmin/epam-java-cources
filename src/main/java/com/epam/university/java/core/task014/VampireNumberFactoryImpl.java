package com.epam.university.java.core.task014;

public class VampireNumberFactoryImpl implements VampireNumberFactory {

    @Override
    public VampireNumberImpl newInstance(int multiplication, int first, int second) {
        return new VampireNumberImpl(multiplication, first, second);
    }
}
