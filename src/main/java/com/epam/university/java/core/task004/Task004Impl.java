package com.epam.university.java.core.task004;

public class Task004Impl implements Task004 {
    /**
     * Find intersection of two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return array of common elements
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] arr = new String[first.length + second.length];
        int i = 0;
        for (String string1 : first) {
            for (String string2 : second) {
                if (string1.equals(string2)) {
                    arr[i++] = string1;
                }
            }
        }
        int numberOfNulls = 0;
        for (String str : arr) {
            if (str == null) {
                numberOfNulls++;
            }
        }
        int len = arr.length - numberOfNulls;
        String[] result = new String[len];
        for (int j = 0; j < len; j++) {
            result[j] = arr[j];
        }
        return result;
    }

    /**
     * Find union of two arrays.
     *
     * @param first  first array
     * @param second second array
     * @return array of all elements of array
     * @throws IllegalArgumentException if parameters not provided
     */
    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] arr = new String[first.length + second.length];
        int i = 0;
        for (String string1 : first) {
            arr[i++] = string1;
        }
        boolean flag;
        for (String string2 : second) {
            flag = true;
            for (String string : arr) {
                if (string2.equals(string)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                arr[i++] = string2;
            }

        }
        int numberOfNulls = 0;
        for (String str : arr) {
            if (str == null) {
                numberOfNulls++;
            }
        }
        int len = arr.length - numberOfNulls;
        String[] result = new String[len];
        for (int j = 0; j < len; j++) {
            result[j] = arr[j];
        }
        return result;
    }
}
