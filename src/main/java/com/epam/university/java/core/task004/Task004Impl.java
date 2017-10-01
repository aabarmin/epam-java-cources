package com.epam.university.java.core.task004;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        } else {
            List<String> result = Arrays
                    .stream(first)
                    .filter(s -> ArrayUtils.contains(second,s))
                    .collect(Collectors.toList());

            return result.toArray(new String[result.size()]);
        }
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        } else {
            ArrayList<String> result = new ArrayList<>();
            result.addAll(Arrays.asList(first));
            for (String s: second) {
                if (!result.contains(s)) {
                    result.add(s);
                }
            }

            return result.toArray(new String[result.size()]);
        }
    }
}
