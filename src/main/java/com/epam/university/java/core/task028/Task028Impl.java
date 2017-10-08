package com.epam.university.java.core.task028;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ilya on 03.10.17.
 */
public class Task028Impl implements Task028 {

    private List<Set<Integer>> variants = new ArrayList<>();


    @Override
    public int getWays(int value, int power) {
        int max = (int) Math.pow(value, 1.0 / (double) power);

        final List<Integer> powers = Stream
            .iterate(1, n -> n + 1)
            .limit(max)
            .map(n -> (int) Math.pow(n, power))
            .collect(Collectors.toList());

        recursion(value, powers, 0, new HashSet<>());

        return variants.size();
    }

    private void recursion(int value,
        final List<Integer> powers,
        int counter,
        final Set<Integer> variant) {
        if (counter > powers.size() - 1) {
            int sum = variant.stream().mapToInt(e -> e).sum();
            if (sum == value) {
                variants.add(variant);
            }
            return;
        }
        Set<Integer> newVariant = new HashSet<>(variant);
        recursion(value, powers, counter + 1, newVariant);
        newVariant.add(powers.get(counter));
        recursion(value, powers, counter + 1, newVariant);

    }

}
