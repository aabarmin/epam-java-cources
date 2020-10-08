package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Task020Impl implements Task020 {
    /**
     * <p>
     *     You have a collection of gemstones, each stone is one line in the <code>stones</code>
     *     collection. Each stone consists of several parts, each part is a character
     *     in a stone string. You should determine amount of common parts which all stones
     *     contains.
     *
     *     Try to do it in a functional approach.
     * </p>
     * <p>
     *     Example: stones are [abc, bcd, cde], result is 1 because only part 'c' is in all stones.
     *     Example: stones are [abc, cde, efg], result is 0 because there are no common parts.
     * </p>
     * @param stones stones collection
     * @return amount of common parts
     */
    @Override
    public int calculate(Collection<String> stones) {
        if (stones == null || stones.size() == 0) {
            throw new IllegalArgumentException();
        }
        Set<Character> result = new TreeSet<>();
        Set<Character> characters;
        boolean isFirst = true;
        for (String stone : stones) {
            characters = new TreeSet<Character>();
            for (int i = 0; i < stone.length(); i++) {
                characters.add(stone.charAt(i));
            }
            if (isFirst) {
                result = characters;
                isFirst = false;
            } else {
                result.retainAll(characters);
            }

        }
        return result.size();
    }
}
