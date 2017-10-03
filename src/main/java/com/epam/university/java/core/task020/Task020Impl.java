package com.epam.university.java.core.task020;

import com.epam.university.java.core.utils.common.Validator;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class implements Task020.
 */
public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        Validator.validateNotNull(stones, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Long longCollectionSize = new Long(stones.size());
        Map<Character, Long> gemstonesMap = stones.parallelStream()
                .flatMap(string -> string.chars().parallel()
                        .mapToObj(i -> (char) i)
                        .filter(distinctByValue(character -> character)))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        List<Map.Entry<Character, Long>> commonGemstones = gemstonesMap
                .entrySet()
                .parallelStream()
                .filter(entry -> entry.getValue().equals(longCollectionSize))
                .collect(Collectors.toList());
        System.out.println(commonGemstones);
        return commonGemstones.size();
    }

    /**
     * Return predicate that checks if value of stream is unique.
     *
     * @param function function
     * @return <code>Predicate</code> for checking the uniqueness test
     * @throws IllegalArgumentException if parameter is null
     */
    public static <T> Predicate<T> distinctByValue(Function<? super T, ?>
                                                           function) {
        Validator.validateNotNull(function,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(function.apply(t),
                Boolean.TRUE) == null;

    }
}