package com.epam.university.java.core.task004;

import com.epam.university.java.core.Validator;

import java.util.Arrays;

public class Task004Impl implements Task004 {
    private Validator validator = Validator.getInstance();

    @Override
    public String[] intersection(String[] first, String[] second) {
        validator.vaildate(first, second);
        String[] result = new String[first.length];
        int i = 0;
        for (String s : first) {
            if (this.contains(s, second)) {
                result[i++] = s;
            }
        }
        int newSize = countNonNull(result);
        return Arrays.copyOfRange(result, 0, newSize);

        //return Arrays.stream(first).filter(s -> contains(s,second)).toArray(String[]::new);
    }

    private int countNonNull(String[] source) {
        int i = 0;
        for (String s : source) {
            if (s != null) {
                i++;
            }
        }
        return i;
    }

    private boolean contains(String key, String[] data) {
        boolean result = false;
        for (String s : data) {
            if (key.equals(s)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        validator.vaildate(first, second);
        String[] result = new String[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        int i = first.length;
        for (String s : second) {
            if (!this.contains(s, result)) {
                result[i++] = s;
            }
        }
        int newSize = countNonNull(result);
        return Arrays.copyOfRange(result, 0, newSize);

        //        System.arraycopy(second, 0, result, first.length, second.length);
        //        return Arrays.stream(result).distinct().toArray(String[]::new);
    }
}
