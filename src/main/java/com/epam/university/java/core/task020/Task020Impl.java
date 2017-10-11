package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ilya on 23.09.17.
 */
public class Task020Impl implements Task020 {

    @Override
    public int calculate(Collection<String> stones) {

        Set<String> strings = stones.stream()
            .map(s -> Stream.of(s.split(""))
                .collect(Collectors.toSet()))
            .reduce((s1, s2) -> {
                s1.retainAll(s2);
                return s1;
            }).get();

        return strings.size();
    }
}
