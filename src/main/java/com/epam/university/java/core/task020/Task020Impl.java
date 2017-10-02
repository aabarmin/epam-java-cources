package com.epam.university.java.core.task020;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        return stones.stream()
                .map((s) -> Arrays.stream(s.split("")).collect(Collectors.toSet()))
                .reduce((s1, s2) -> {
                    s1.retainAll(s2);
                    return s1;
                })
                .get().size();
    }
}
