package com.epam.university.java.core.task003;

import java.util.*;
import java.util.stream.Collectors;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source != null) {
            int len = source.length;
            String[] newArr = new String[len];
            for (int i = 0; i < len; i++) {
                newArr[i] = source[len - 1 - i];
            }
            return newArr;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first != null && second != null) {
            int len = first.length + second.length;
            String[] newArr = new String[len];
            System.arraycopy(first, 0, newArr, 0, first.length);
            System.arraycopy(second, 0, newArr, first.length, second.length);
            return newArr;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int findMax(int[] source) {
        if (source != null && source.length != 0) {
            int max = Integer.MIN_VALUE;
            for (int num : source) {
                max = Math.max(num, max);
            }
            return max;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source != null && condition != null) {
            List<String> listArr = Arrays.stream(source)
                    .filter(condition::isValid)
                    .collect(Collectors.toList());
            String[] newArr = new String[listArr.size()];
            newArr = listArr.toArray(newArr);
            return newArr;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source != null && toRemote != null) {
            ArrayList<String> listArr = new ArrayList<>(Arrays.asList(source));
            ArrayList<String> listRemove = new ArrayList<>(Arrays.asList(toRemote));
            listArr.removeAll(listRemove);
            String[] newArr = new String[listArr.size()];
            newArr = listArr.toArray(newArr);
            return newArr;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source != null && operation != null) {
            for (int i = 0; i < source.length; i++) {
                source[i] = operation.map(source[i]);
            }
            return source;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source != null && operation != null) {
            if (source.length == 0) {
                return source;
            }
            StringBuilder sourceSb = new StringBuilder();
            for (int i = 0; i < source.length; i++) {
                sourceSb.append(source[i]).append(", ");
            }
            String[] resArr;
            resArr = operation.flatMap(sourceSb.toString());
            return resArr;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
