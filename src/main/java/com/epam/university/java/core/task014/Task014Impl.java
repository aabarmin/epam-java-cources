package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Set<Integer> numbersList = new HashSet<>();
        for (int i = 1011; i < 9999; i++) {
            if (!containsTwoZeros(i)) {
                numbersList.add(i);
            }
        }

        Collection<VampireNumber> vampires = new ArrayList<>();
        for (Integer vamp : numbersList) {
            VampireNumber vampireNumber = convertToVampireNumberIfPossible(vamp);
            if (vampireNumber != null) {
                vampires.add(vampireNumber);
            }
        }

        return vampires;
    }

    private static boolean containsTwoZeros(Integer integer) {
        String s = String.valueOf(integer);
        String[] strings = s.split("");

        int countZeros = 0;
        for (String str : strings) {
            if (str.equals("0")) {
                countZeros++;
            }
            if (countZeros > 1) {
                return true;
            }
        }

        return false;
    }

    private VampireNumber convertToVampireNumberIfPossible(Integer value) {
        Integer[] digitArr = getArrOfDigits(value);

        List<Integer> setOfTwoDigits = getSetOfTwoDigitFromInteger(digitArr);
        VampireNumber resultNumber = null;

        for (int i = 0; i < setOfTwoDigits.size(); i++) {
            int currentI = setOfTwoDigits.get(i);
            int currentRotatedI = rotateTwoDigits(setOfTwoDigits.get(i));
            boolean vampireNumberWasFound = false;

            for (int j = i + 1; j < setOfTwoDigits.size(); j++) {
                int currentJ = setOfTwoDigits.get(j);
                int currentRotatedJ = rotateTwoDigits(setOfTwoDigits.get(j));

                StringBuilder b = new StringBuilder();
                b.append(currentI).append(currentJ);
                Integer[] tmpArr = getArrOfDigits(Integer.parseInt(b.toString()));
                Arrays.sort(tmpArr);
                Arrays.sort(digitArr);

                boolean arrEq = Arrays.equals(tmpArr, digitArr);
                if (arrEq) {
                    int first = 0;
                    int second = 0;
                    if (currentI * currentJ == value) {
                        first = currentI;
                        second = currentJ;
                    } else if (currentI * currentRotatedJ == value) {
                        first = currentI;
                        second = currentRotatedJ;
                    } else if (currentRotatedI * currentJ == value) {
                        first = currentRotatedI;
                        second = currentJ;
                    } else if (currentRotatedI * currentRotatedJ == value) {
                        first = currentRotatedI;
                        second = currentRotatedJ;
                    }

                    if (first != 0 && second != 0) {
                        resultNumber = new VampireNumberImpl(value, first, second);
                        vampireNumberWasFound = true;
                    }
                }

            }

            if (vampireNumberWasFound) {
                break;
            }
        }

        return resultNumber;
    }

    private List<Integer> getSetOfTwoDigitFromInteger(Integer[] value) {
        List<Integer> resultSet = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            if (value[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < value.length; j++) {
                builder.append(value[i]).append(value[j]);
                resultSet.add(Integer.parseInt(builder.toString()));
                builder = new StringBuilder();
            }

        }

        return resultSet;
    }

    private Integer rotateTwoDigits(Integer integer) {
        if (integer.toString().length() != 2) {
            throw new IllegalArgumentException();
        }

        StringBuilder builder = new StringBuilder(integer.toString());
        builder.reverse();
        return Integer.parseInt(builder.toString());
    }

    private Integer[] getArrOfDigits(Integer integer) {
        final int base = 10;

        Integer[] resultArr = new Integer[integer.toString().length()];

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[resultArr.length - 1 - i] = integer % base;
            integer /= base;
        }

        return resultArr;
    }
}
