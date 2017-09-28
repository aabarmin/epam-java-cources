package com.epam.university.java.core.task020;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * {@inheritDoc}
 */
public class Task020Impl implements Task020 {
    /**
     * {@inheritDoc}
     */
    @Override
    public int calculate(Collection<String> stones) {
        Map<String, Integer> mapOfStones = new HashMap<>();
        stones.forEach(stone -> Arrays.stream(stone.split("")).
                forEach(letter -> mapOfStones.merge(letter, 1, (old, incr) -> old + 1)));

        long count = mapOfStones.values().
                stream().
                filter(i -> i == stones.size()).count();
        return (int) count;
    }
}
