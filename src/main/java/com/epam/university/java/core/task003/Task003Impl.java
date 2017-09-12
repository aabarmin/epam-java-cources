package com.epam.university.java.core.task003;

import java.lang.annotation.Inherited;
import java.util.Arrays;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException("Array not provided!");
        }
        return reverseArr(source);
    }

    /**
     * Reverse array with any type.
     *
     * @param values source array
     * @return reverse array
     */
    public static <T> T[] reverseArr(T[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Array not provided!");
        }
        for (int i = 0, j = values.length - 1; i < values.length / 2
                && j > (values.length - 1) / 2; i++, j--) {
            T str = values[i];
            values[i] = values[j];
            values[j] = str;
        }
        return values;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Arrays not provided!");
        }
        String[] third = new String[first.length + second.length];
        for (int i = 0, j = 0, k = 0; i < third.length; i++) {
            if (i < first.length) {
                third[i] = first[j++];
            } else {
                third[i] = second[k++];
            }
        }
        return third;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException("Array not provided!");
        }
        int max = source[0];
        for (int i : source) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException("Array or condition not provided!");
        }
        int countElement = 0;
        boolean[] mask = new boolean[source.length];
        for (int i = 0; i < source.length; i++) {
            if (condition.isValid(source[i])) {
                mask[i] = true;
                countElement++;
            }
        }

        String[] filterArr = new String[countElement];
        for (int i = 0, j = 0; i < source.length && j < filterArr.length; i++) {
            if (mask[i]) {
                filterArr[j++] = source[i];
            }
        }

        return filterArr;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException("Arrays not provided!");
        }
        String[] finalString = new String[source.length];

        for (String str : toRemote) {
            for (int i = 0, j = 0; i < finalString.length && j < source.length; j++) {
                if (!str.equals(source[j]) && str != null) {
                    finalString[i++] = source[j];
                }
            }
            int count = 0;
            for (String s : finalString) {
                if (s != null) {
                    count++;
                }
            }

            source = finalString;
            if (finalString.length != count) {
                finalString = new String[count];
            }
        }

        for (int n = 0, q = 0; n < source.length; n++) {
            if (source[n] != null) {
                finalString[q++] = source[n];
            }
        }
        return finalString;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException("Parameters not provided!");
        }
        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException("Parameters not provided!");
        }

        String[][] strArrArr = new String[source.length][];
        for (int i = 0; i < source.length; i++) {
            strArrArr[i] = operation.flatMap(source[i]);
        }

        int count = 0;
        for (String[] strings : strArrArr) {
            count += strings.length;
        }

        String[] strArr = new String[count];
        for (int i = 0, k = 0; i < strArrArr.length; i++) {
            for (int j = 0; j < strArrArr[i].length; j++) {
                strArr[k++] = strArrArr[i][j];
            }
        }

        Integer[] numArr = new Integer[strArr.length];
        try {
            for (int i = 0; i < numArr.length; i++) {
                numArr[i] = Integer.parseInt(strArr[i]);
            }
        } catch (NumberFormatException e) {
            numArr = null;
        }

        if (numArr != null) {
            Arrays.sort(numArr);
            return reverseArr(removeDuplicates(numArr));
        } else {
            Arrays.sort(strArr);
            return reverseArr(removeDuplicates(strArr));
        }
    }

    /**
     * Remove duplicates in array.
     *
     * @param values source array
     * @return new array without duplicates
     */
    public static <T> String[] removeDuplicates(T[] values) {
        boolean[] mask = new boolean[values.length];
        int removeCount = 0;

        for (int i = 0; i < values.length; i++) {
            if (!mask[i]) {
                for (int j = i + 1; j < values.length; j++) {
                    if (values[i].equals(values[j])) {
                        mask[j] = true;
                        removeCount++;
                    }
                }
            }
        }

        String[] result = new String[values.length - removeCount];

        for (int i = 0, j = 0; i < values.length; i++) {
            if (!mask[i]) {
                result[j++] = String.valueOf(values[i]);
            }
        }
        return result;
    }
}
