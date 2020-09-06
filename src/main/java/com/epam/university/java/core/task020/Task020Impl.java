package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        Map<Character, Integer> myMap = new HashMap<>();
        for (String s : stones
        ) {
            for (int i = 0; i < s.length(); i++) {
                if (myMap.containsKey(s.charAt(i))) {
                    int temp = myMap.get(s.charAt(i));
                    temp++;
                    myMap.put(s.charAt(i), temp);
                } else {
                    myMap.put(s.charAt(i), 1);
                }
            }
        }

        int maxValue = 0;
        int countRes = 0;

        for (Map.Entry<Character, Integer> entry : myMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }


        for (Map.Entry<Character, Integer> entry : myMap.entrySet()) {
            if (entry.getValue() >= stones.size()) {
                countRes++;
            }
        }


        return countRes;
    }
}
