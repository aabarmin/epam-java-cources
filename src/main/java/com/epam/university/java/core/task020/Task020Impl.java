package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for Task020.
 *
 * @author Sergei Titov
 */
public class Task020Impl implements Task020 {

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculate(Collection<String> stones) {

        // first element from collection
        List<Character> first = stones.stream()
                .findFirst()
                .get()
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList());

        // check each letter in first word if it presents in each of the following words
        for (String stone : stones) {
            first.toString().chars()
                    .mapToObj(c -> (char)c)
                    .filter(c -> stone.indexOf(c) < 0)
                    .forEach(c -> first.remove(c));
        }
        return first.size();
    }


}
