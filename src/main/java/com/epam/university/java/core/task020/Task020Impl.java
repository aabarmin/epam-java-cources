package com.epam.university.java.core.task020;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        if (stones == null) {
            throw new IllegalArgumentException("Collection wasn't provided!");
        }
        Set<String> stringSet = new HashSet<>();
        stones.stream()
                .findFirst()
                .ifPresent(a -> stringSet.addAll(Arrays.asList(a.split(""))));
        int count = 0;
        for (String s : stringSet) {
            if (stones.stream()
                    .allMatch(a -> a.contains(s))) {
                count++;
            }
        }
        return count;
    }
}