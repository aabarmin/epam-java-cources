package com.epam.university.java.core.task028;

import java.util.ArrayList;

/**
 * Created by Daniil Smirnov on 08.10.2017.
 * All copy registered MF.
 */
public class Task028Impl implements Task028 {

    private int result = 0;
    private ArrayList<Integer> values = new ArrayList<>();

    @Override
    public int getWays(int value, int power) {

        tryingNextOne(value, value, power, 0);
        return result;
    }

    private void tryingNextOne(int value, int dif, int power, int another) {

        if (dif == 0) {
            result++;
        }

        int board = (int) Math.floor(
                Math.pow(value, 1.0 / power)
        );

        for (int i = another + 1; i <= board; i++) {
            int newDif = dif - (int) Math.pow(i, power);
            if (newDif >= 0) {
                tryingNextOne(value, newDif, power, i);
            }
        }
    }

}
