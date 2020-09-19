package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task020Impl implements Task020 {
    /**
     * You have a collection of gemstones, each stone is one line in the <code>stones</code>
     * collection. Each stone consists of several parts, each part is a character
     * in a stone string. You should determine amount of common parts which all stones
     * contains.
     * <p>
     * Try to do it in a functional approach.
     * </p>
     * <p>
     * Example: stones are [abc, bcd, cde], result is 1 because only part 'c' is in all stones.
     * Example: stones are [abc, cde, efg], result is 0 because there are no common parts.
     * </p>
     *
     * @param stones stones collection
     * @return amount of common parts
     */
    @Override
    public int calculate(Collection<String> stones) {
        if (stones == null || stones.size() == 0) {
            throw new IllegalArgumentException();
        }

        return count(stones);
    }

    private boolean isCharInTheCollection(Collection<String> collection, char c) {
        for (String s :
                collection) {
            if (s.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    private char[] removeDuplicates(char[] chars) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }

        char[] charArrWithNoDublicates = new char[set.size()];
        Iterator<Character> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            charArrWithNoDublicates[i++] = it.next();
        }
        return charArrWithNoDublicates;
    }

    private int count(Collection<String> stones) {
        int counter = 0;
        Object[] objects = stones.toArray();
        char[] chars = objects[0]
                .toString()
                .toCharArray();
        char[] uniqueChar = removeDuplicates(chars);
        for (char c :
                uniqueChar) {
            if (isCharInTheCollection(stones, c)) {
                counter++;
            }
        }
        return counter;
    }
}
