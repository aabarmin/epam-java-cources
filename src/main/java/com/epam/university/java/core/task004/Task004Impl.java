package com.epam.university.java.core.task004;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if ( first == null || second == null ) {
            throw new IllegalArgumentException();
        }
        else {
            List<String> result = Arrays
                    .stream(first)
                    .filter(s->ArrayUtils.contains(second,s))
                    .collect(Collectors.toList());
            return result.toArray(new String[result.size()]);
        }
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if ( first == null || second == null ) {
            throw new IllegalArgumentException();
        }
        else {
            List<String> result = Arrays
                    .stream(first)
                    .flatMap( s-> )
        }
    }
}
