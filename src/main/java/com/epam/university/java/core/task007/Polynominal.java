package com.epam.university.java.core.task007;

/**
 * Author Dmitry Novikov 20-Sep-20.
 */
class Polynominal {
    private int number;
    private int power;

    public Polynominal(int number, int power) {
        this.number = number;
        this.power = power;
    }

    public int getNumber() {
        return number;
    }

    public int getPower() {
        return power;
    }

    public String toString() {
        return number + ";" + power;
    }
}
