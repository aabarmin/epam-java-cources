package com.epam.university.java.core.task020;

import com.epam.university.java.core.util.Utils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Gemstones.
 */
public class Task020Impl implements Task020 {

    /**
     * <p>
     *     You have a collection of gemstones, each stone is one line in the <code>stones</code>
     *     collection. Each stone consists of several parts, each part is a character
     *     in a stone string. You should determine amount of common parts which all stones
     *     contains.
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
        Utils.assertNonNull(stones);
        if (stones.isEmpty()) {
            return 0;
        }
        final String first = stones.iterator().next();
        return stones
            .stream()
            .reduce(
                first,
                this::intersectWithRepetitions
            ).length();
    }

    /**
     * Returns String containing characters that are present in both Strings.
     * <p>
     *     Repeating chars are allowed. Example:
     *          <code>
     *              intersectWithRepetitions("This is an example string", "hello there, my friend")
     *          </code>
     *          should return something like "hi  n emletr" (12 characters)
     * </p>
     * @param first first String
     * @param second second String
     * @return intersection String
     */
    private String intersectWithRepetitions(String first, String second) {
        final Map<Character, Long> occ = second.chars()
            .mapToObj(i -> (char)i)
            .collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
            );
        final StringBuilder sb = new StringBuilder();
        first.chars()
            .mapToObj(i -> (char)i)
            .forEach(ch -> {
                final long occur = occ.getOrDefault(ch, 0L);
                if (occur > 0) {
                    sb.append(ch);
                    occ.compute(ch, (key, val) -> --val);
                }
            });
        return sb.toString();
    }

}
