package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder {

    private int firstNum;
    private int secondNum;

    @Override
    public int getFirst() {
        return firstNum;
    }

    @Override
    public int getSecond() {
        return secondNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }
}
