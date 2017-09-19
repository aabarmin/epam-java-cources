package com.epam.university.java.core.task014;

import java.util.Collection;
import java.util.ArrayList;

/**
 * Created by Daniil Smirnov on 19.09.2017.
 * All copy registered MF.
 */
public class Task014Impl implements Task014 {

    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Collection<VampireNumber> vampireNumbers = new ArrayList<>();
        for (int i = 1000;i <= 9999;i++) {
            for (int j = 1; j <= 99; j++) {
                for (int k = 1; k <= 99; k++) {
                    if (checkForVampires(i,j,k)) {
                        if (j < k) {
                            VampireNumber vn = new VampireNumberImpl(i,j,k);
                            if (!vampireNumbers.contains(vn)) {
                                vampireNumbers.add(vn);
                            }
                        } else {
                            VampireNumber vn = new VampireNumberImpl(i,k,j);
                            if (!vampireNumbers.contains(vn)) {
                                vampireNumbers.add(vn);
                            }
                        }
                    }
                }
            }
        }
        return vampireNumbers;
    }

    private boolean checkForVampires(int mult, int first, int second) {
        String multString = String.valueOf(mult);
        String firstString = String.valueOf(first);
        String secondString = String.valueOf(second);
        if (mult == first * second) {
            if (!firstString.contains("0") || !secondString.contains("0")) {
                ArrayList<String> a = new ArrayList<>(4);
                String[] array = multString.split("");
                for (int i = 0;i < multString.length();i++) {
                    a.add(array[i]);
                }
                for (String s : firstString.split("")) {
                    if (a.contains(s)) {
                        a.remove(s);
                    } else {
                        return false;
                    }
                }
                for (String s : secondString.split("")) {
                    if (a.contains(s)) {
                        a.remove(s);
                    } else {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
