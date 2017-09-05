package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


/**
 * Class for union and intersection operations with string arrays.
 * Task004 implementation.
 */
public final class Task004Impl implements Task004 {

    /**
     * * Message for source not provided error.
     */
    private static final String MSG_NULL_SOURCE = "source not provided";

    @Override
    public String[] intersection(final String[] first, final String[] second) {
        if ((first == null) || second == null) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }

        List<String> firstList = Arrays.asList(first);
        List<String> secondList = Arrays.asList(second);
        List<String> resultList = new ArrayList<>(firstList);

        resultList = resultList.stream()
                .filter(secondList::contains)
                .collect(Collectors.toList());

        //removing duplicates
        resultList = resultList.stream()
                .collect(collectingAndThen(toCollection(LinkedHashSet::new),
                        ArrayList::new));


        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);

        return resultArray;
    }

    @Override
    public String[] union(final String[] first, final String[] second) {
        if ((first == null) || second == null) {
            throw new IllegalArgumentException(MSG_NULL_SOURCE);
        }

        List<String> firstList = Arrays.asList(first);
        List<String> secondList = Arrays.asList(second);
        secondList = secondList.stream()
                .filter(str -> !firstList.contains(str))
                .collect(Collectors.toList());

        List<String> resultList = new ArrayList<>(firstList);
        resultList.addAll(secondList);

        //removing duplicates
        resultList = resultList.stream()
                .collect(collectingAndThen(toCollection(LinkedHashSet::new),
                        ArrayList::new));

        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);

        return resultArray;
    }
}
