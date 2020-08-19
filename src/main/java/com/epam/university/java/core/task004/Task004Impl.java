package com.epam.university.java.core.task004;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        return Stream.of(first).filter((e) -> {
            for (String s : second) {
                if (s.equals(e)) {
                    return true;
                }
            }
            return false;
        }).toArray(String[]::new);
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        Stream<String> one = Stream.of(first);
        Stream<String> two = Stream.of(second);

        return Stream.concat(one, two).distinct().toArray(String[]::new);

    }
}
