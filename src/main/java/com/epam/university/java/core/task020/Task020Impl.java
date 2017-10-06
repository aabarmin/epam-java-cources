package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        return stones.stream().map(x -> Stream.of(x.split(""))
                                       .collect(Collectors.toSet()))
                       .reduce((x1,x2) -> {
                          x1.retainAll(x2);
                          return x1;}).get().size();
    }
}
