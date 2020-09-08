package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Romin Nuro on 08.09.2020 13:29.
 */
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
        Set<String> resultSet = stones.stream().map(s -> s.split(""))
                .map(strings -> {
                    Set<String> set = new HashSet<>();
                    Collections.addAll(set, strings);
                    return set;
                })
                .reduce((set1, set2) -> {
                    Set<String> result = new HashSet<>();
                    for (String one : set1) {
                        for (String two : set2) {
                            if (one.equals(two)) {
                                result.add(one);
                            }
                        }
                    }
                    return result;
                })
                .orElse(new HashSet<String>());
        return resultSet.size();
    }
}
