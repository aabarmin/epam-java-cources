package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Collection<VampireNumber> vampireNumbers = new ArrayList<>();
        for (int first = 15; first < 100; first++) {
            for (int second = first; second < 100; second++) {
                if (isVampire(first,second)) {
                    vampireNumbers.add(new VampireNumberImpl(
                            first * second,
                            first,
                            second));
                }
            }
        }
        return vampireNumbers;
    }

    private boolean isVampire(int first, int second) {
        ArrayList<Integer> digits = new ArrayList<>();
        digits.add(first / 10);
        digits.add(first % 10);
        digits.add(second / 10);
        digits.add(second % 10);
        int mul;
        for (int i = 0; i < digits.size(); i++) {
            mul = digits.remove(i) * 1000;
            for (int j = 0; j < digits.size(); j++) {
                mul += 100 * digits.remove(j);
                for (int k = 0; k < digits.size(); k++) {
                    mul += 10 * digits.remove(k);
                    mul += digits.remove(0);
                    if (mul == first * second) {
                        return true;
                    }
                    digits.add(0, mul % 10);
                    digits.add(k, mul % 100 / 10);
                    mul -= mul % 100;
                }
                digits.add(j,mul % 1000 / 100);
                mul -= mul % 1000;
            }
            digits.add(i, mul / 1000);
        }
        return false;
    }
}
