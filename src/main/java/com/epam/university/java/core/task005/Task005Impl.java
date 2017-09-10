package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {


    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException("Digits less or equals to the zero, or more than ten!");
        }
        //PiHolder numbers = new PiHolderImpl();
        //numbers.
        return numbers;
    }
}
