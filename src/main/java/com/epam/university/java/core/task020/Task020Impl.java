package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        // map of chars and their repetitions
        Map<Character, Integer> charMap = new HashMap<>();

        // filling up the map
        stones.forEach(s -> s.chars()
                .forEach(c ->
                        charMap.merge((char) c, 1, (a, b) -> a + b)
                )
        );

        // return count of chars that are repeated in all strings
        return (int) charMap.entrySet().stream().filter(o ->
                o.getValue() == stones.size()).count();
    }
}
