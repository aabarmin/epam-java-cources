package com.epam.university.java.core.task028;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        int maxValSqr = (int) Math.round(Math.sqrt(value));
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= maxValSqr; i++) {
            result.add((int)Math.round(Math.pow(i, power)));
        }
        return count(result, 0, value);
    }

    private int count(ArrayList<Integer> result, int ind, int val) {
        int fin = 0;
        for (int i = ind; i < result.size(); i++) {
            if (result.get(i) == val) {
                fin++;
            }
            if (result.get(i) > val) {
                continue;
            }
            if (result.get(i) < val) {
                fin += count(result, i + 1, val - result.get(i));
            }
        }
        return fin;
    }
}
