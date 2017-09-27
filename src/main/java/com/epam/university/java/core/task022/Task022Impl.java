package com.epam.university.java.core.task022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Created by ilya on 25.09.17.
 */
public class Task022Impl implements Task022 {

    @Override
    public int maxSum(Collection<Integer> numbers) {
        return calculation(numbers, (s, c) -> (s.min(c)));
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        return calculation(numbers, (s, c) -> (s.max(c)));
    }

    private int calculation(Collection<Integer> numbers,
        BiFunction<Stream<Integer>, Comparator<Integer>, Optional<Integer>> function) {
        List<Integer> numbersList = new ArrayList<>();

        numbersList.addAll(numbers);

        Integer removabel = function.apply(numbersList.stream(), Integer::compareTo)
            .get();

        numbersList.remove(removabel);

        return numbersList.stream().mapToInt(n -> n).sum();
    }

}
