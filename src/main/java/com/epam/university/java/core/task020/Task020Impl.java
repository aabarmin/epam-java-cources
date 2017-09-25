package com.epam.university.java.core.task020;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Task020Impl implements Task020 {

    @Override
    public int calculate(Collection<String> stones) {
        int result;
        result = stones.stream()
                .map(n -> Arrays.stream(n.split(""))
                .collect(HashSet<String>::new, (j, k) -> j.add(k), HashSet::addAll))
                .reduce((n, m) -> {
                    n.retainAll(m);
                    return n;
                }).get().size();
        return result;
    }
}