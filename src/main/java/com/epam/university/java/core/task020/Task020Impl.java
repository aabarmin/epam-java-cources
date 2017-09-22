package com.epam.university.java.core.task020;

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
        int mainCounter = 0;
        Map<Character, Integer> mapOfStones = new HashMap<>();
        for (String stone : stones) {
            for (char c : stone.toCharArray()) {
                Integer count = mapOfStones.put(c, 1);
                if (count != null) {
                    mapOfStones.put(c, ++count);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : mapOfStones.entrySet()) {
            if (entry.getValue() == stones.size()) {
                mainCounter++;
            }
        }
        return mainCounter;
    }
}
