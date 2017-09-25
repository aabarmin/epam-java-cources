package com.epam.university.java.core.task004;

import com.epam.university.java.core.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task004Impl implements Task004 {

    @Override
    public String[] intersection(String[] first, String[] second) {
        Validator.validateNotNull(first, second,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List<String> intersectionList = new ArrayList<>(
                new ArrayList<>(Arrays.asList(first)))
                .stream()
                .filter(new ArrayList<>(Arrays.asList(second))::contains)
                .collect(Collectors.toList());
        return intersectionList.toArray(new String[0]);
    }

    @Override
    public String[] union(String[] first, String[] second) {
        Validator.validateNotNull(first, second,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List<String> unionList = Stream
                .concat(new ArrayList<>(new ArrayList<>(
                                Arrays.asList(first))).stream(),
                        new ArrayList<>(new ArrayList<>(
                                Arrays.asList(second))).stream())
                .filter(distinctByValue(var -> var))
                .collect(Collectors.toList());
        return unionList.toArray(new String[0]);
    }

    /**
     * Validation of checking the stream for duplicates and special value.
     *
     * @param function Function, stream object
     *                 can be changed
     * @return <T>Predicate<T> for checking the stream
     * @throws IllegalArgumentException if parameter is null
     */
    public static <T> Predicate<T> distinctByValue(Function<? super T, ?>
                                                           function) {
        Validator.validateNotNull(function,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> {
            if (function.apply(t).equals("")) {
                return true;
            } else {
                return seen.putIfAbsent(function.apply(t),
                        Boolean.TRUE) == null;
            }
        };
    }
}