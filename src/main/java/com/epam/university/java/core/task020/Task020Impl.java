package com.epam.university.java.core.task020;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.util.ArrayList;
import java.util.Collection;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        char[] result = stones.stream()
                .map(String::toCharArray)
                .reduce((chars, chars2) -> {
                    char[] intermediate;
                    intermediate = intersect(chars,chars2);
                    return intermediate;
                })
                .orElse(null);

        return result != null ? result.length : 0;
    }

    private static char[] intersect(char[] first, char[] second) {
        ArrayList<Character> firstL = new ArrayList<>();
        ArrayList<Character> secondL = new ArrayList<>();

        for (char c:first) {
            firstL.add(c);
        }
        for (char c: second) {
            secondL.add(c);
        }
        Collection<Character> coll = CollectionUtils.intersection(firstL,secondL);
        char[] result = new char[0];
        for (char c: coll) {
            result = ArrayUtils.add(result, c);
        }

        return result;
    }
}
