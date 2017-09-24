package com.epam.university.java.core.task020;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Task020Impl implements Task020 {
    /**
     * <p>
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

        List<String> stonesList = new ArrayList<>(stones);

        Set<Character> commonParts = new HashSet<>();

        if (stones == null) {
            throw new IllegalArgumentException();
        }

        if (stones.size() == 0) {
            return 0;
        }

        char[] firstStoneParts = stonesList.get(0).toCharArray();

        if (stonesList.size() == 1) {
           return firstStoneParts.length;
        }

        stonesList.remove(0);

        for (char part : firstStoneParts) {
            if (stonesList.stream().allMatch(stone -> stone.indexOf(part) > -1)) {
                commonParts.add(part);
            }
        }

        return commonParts.size();

    }
}
