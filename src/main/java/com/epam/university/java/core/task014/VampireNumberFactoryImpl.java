package com.epam.university.java.core.task014;

/**
 * Created by Вера on 19.09.2017.
 */
public class VampireNumberFactoryImpl implements VampireNumberFactory {
    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {
        VampireNumber vampireNumber = new VampireNumberImpl(multiplication, first, second);
        return vampireNumber;
    }
}
