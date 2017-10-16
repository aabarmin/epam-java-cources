package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    private int numberOfWays;
    private int power;
    private int value;

    @Override
    public int getWays(int value, int power) {
        this.value = value;
        this.power = power;
        findTheDecomposition(0, 1);
        return numberOfWays;
    }

    private void findTheDecomposition(int sum, int number) {
        int addition = (int) Math.pow(number, power);
        if (addition <= value - sum) {
            findTheDecomposition(sum, number + 1);
            sum += addition;
            if (sum == value) {
                numberOfWays++;
            } else if (sum < value) {
                findTheDecomposition(sum, number + 1);
            }
        }
    }
}
