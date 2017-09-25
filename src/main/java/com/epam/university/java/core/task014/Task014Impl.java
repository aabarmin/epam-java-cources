package com.epam.university.java.core.task014;


import java.util.*;
import java.util.regex.Pattern;

public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Set<VampireNumber> vampireNumberSet = new LinkedHashSet<>();
        for (int number = 1000; number < 10000; number++) {
            int[] numberInArray = new int[Integer.toString(number).length()];
            for (int i = 0; i < numberInArray.length; i++) {
                numberInArray[i] = Character.getNumericValue(Integer.toString
                        (number).charAt(i));
            }
            for (int i = 0; i < numberInArray.length; i++) {
                for (int j = 0; j < numberInArray.length; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < numberInArray.length; k++) {
                        if ((k == j) || (k == i)) {
                            continue;
                        }
                        for (int l = 0; l < numberInArray.length; l++) {
                            if ((l == k) || (l == j) || (l == i)) {
                                continue;
                            }
                            if ((numberInArray[i] * 10 + numberInArray[j])
                                    * (numberInArray[k] * 10 + numberInArray[l])
                                    == number) {
                                vampireNumberSet.add(new VampireNumberImpl(
                                        number, numberInArray[i] * 10
                                        + numberInArray[j],
                                        numberInArray[k] * 10
                                                + numberInArray[l]));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Pattern.compile("^[a-z]([a-z0-9][a-zA-Z0-9]*)?$")
                .matcher("hoCoordinate").find());
        return vampireNumberSet;
    }
}