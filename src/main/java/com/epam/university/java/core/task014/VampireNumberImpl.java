package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    private int multiplication;
    private int first;
    private int second;

    VampireNumberImpl(int mult, int first, int second) {
        this.multiplication = mult;
        this.first = first;
        this.second = second;
    }

    @Override
    public int getMultiplication() {
        return multiplication;
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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        VampireNumberImpl vampire = (VampireNumberImpl) obj;
        return (multiplication == vampire.multiplication && first
                == vampire.second && second == vampire.first)
                || (multiplication == vampire.multiplication && first
                == vampire.first && second == vampire.second);

    }
}
