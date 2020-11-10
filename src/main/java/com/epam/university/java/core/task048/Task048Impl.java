package com.epam.university.java.core.task048;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task048Impl implements Task048 {
    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        if (from == null || to == null || to < 0 || to < from) {
            throw new IllegalArgumentException();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            char[] digits = String.valueOf(i).toCharArray();
            double armstrong = 0;
            for (char digit : digits) {
                armstrong = armstrong + Math.pow(digit - 48, digits.length);
            }
            if ((int) armstrong == i) {
                result.add(i);
            }
        }
        return result;
    }
}
