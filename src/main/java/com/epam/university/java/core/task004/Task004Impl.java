package com.epam.university.java.core.task004;

import com.epam.university.java.core.task003.NullChecker;
import com.epam.university.java.core.task003.SimpleNullChecker;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ilya on 04.09.17.
 */
public class Task004Impl implements Task004 {
    NullChecker checker = new SimpleNullChecker();

    @Override
    public String[] intersection(String[] first, String[] second) {
        checker.check(first,second);

        List<String> resultList = Arrays.stream(first)
                .filter(n -> Arrays.asList(second).contains(n))
                .collect(Collectors.toList());

        return resultList.toArray(new String[0]);
    }

    @Override
    public String[] union(String[] first, String[] second) {
        checker.check(first,second);

        Set<String> resultSet = new HashSet<>();
        Collections.addAll(resultSet, first);
        Collections.addAll(resultSet, second);

        List<String> resultList = resultSet.stream()
                .mapToInt(n -> Dictionary.getInt(n))
                .sorted()
                .mapToObj(n -> Dictionary.getString(n))
                .collect(Collectors.toList());

        return resultList.toArray(new String[0]);
    }
}
