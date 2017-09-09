package com.epam.university.java.core.task004;

import com.epam.university.java.core.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task004Impl implements Task004 {

    @Override
    public String[] intersection(String[] first, String[] second) {
        Validator.validateNotNull(first, second, Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List<String> intersectionList = new ArrayList<>(new ArrayList<>(Arrays.asList(first)))
                .stream()
                .filter(new ArrayList<>(Arrays.asList(second))::contains)
                .collect(Collectors.toList());
        return intersectionList.toArray(new String[0]);
    }

    @Override
    public String[] union(String[] first, String[] second) {
        Validator.validateNotNull(first, second, Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List<String> unionList = Stream
                .concat(new ArrayList<>(new ArrayList<>(Arrays.asList(first))).stream(),
                        new ArrayList<>(new ArrayList<>(Arrays.asList(second))).stream())
                .distinct()
                .collect(Collectors.toList());
        return unionList.toArray(new String[0]);
    }
}