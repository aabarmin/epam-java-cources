package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder{
    private int first;
    private int second;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "PiHolderImpl{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
