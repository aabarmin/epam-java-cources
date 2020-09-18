package com.epam.university.java.core.task028;


public class Task028Impl implements Task028 {

    @Override

    public int getWays(int value, int power) {
        return checkPowers(value, power, 1, 0);
    }


    public int checkPowers(int value, int power, int currentNumber, int currentSum) {
        int numberOfWays = 0;

        int numPow = (int) Math.pow(currentNumber, power);

        while (numPow + currentSum < value) {
            numberOfWays += checkPowers(value, power, currentNumber + 1, numPow + currentSum);
            currentNumber++;
            numPow = (int) Math.pow(currentNumber, power);
        }

        if (numPow + currentSum == value) {
            numberOfWays++;
        }

        return numberOfWays;
    }
}
