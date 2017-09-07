package com.epam.university.java.core.task003;

import com.epam.university.java.core.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task003Impl implements Task003 {
    public static final String errorMessageForConditionIfNull = "condition can't be null";
    public static final String errorMessageForRemovingStringIfNull = "removing string can't be null";
    public static final String errorMessageForOperationIfNull = "operation can't be null";

    @Override
    public String[] invert(String[] source) {
        Validator.validateNotNull(source, Validator.messageForSourceIfNull);
        for (int i = 0; i < source.length / 2; i++) {
            String tempString = source[i];
            source[i] = source[source.length - i - 1];
            source[source.length - i - 1] = tempString;
        }
        return source;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        Validator.validateNotNull(first, second, Validator.messageForFirstParameterIfNull,
                Validator.messageForSecondParameterIfNull);
        return Stream.of(first, second).flatMap(Stream::of).toArray(String[]::new);
    }

    @Override
    public int findMax(int[] source) {
        Validator.validateNotNull(source, Validator.messageForSourceIfNull);
        int[] tempArray = source;
        Arrays.sort(tempArray);
        return tempArray[tempArray.length - 1];
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        Validator.validateNotNull(source, condition, Validator.messageForSourceIfNull,
                errorMessageForConditionIfNull);
        return Stream.of(source).filter(condition::isValid).toArray(String[]::new);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemove) {
        Validator.validateNotNull(source, toRemove, Validator.messageForSourceIfNull,
                errorMessageForRemovingStringIfNull);
        List<String> readyList = new ArrayList<>(Arrays.asList(source));
        readyList.removeAll(Arrays.asList(toRemove));
        return readyList.toArray(new String[0]);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        Validator.validateNotNull(source, operation, Validator.messageForSourceIfNull,
                errorMessageForOperationIfNull);
        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        Validator.validateNotNull(source, operation, Validator.messageForSourceIfNull,
                errorMessageForOperationIfNull);
        String[] tempStrokes = {};
        for (int i = 0; i < source.length; i++) {
            tempStrokes = join(tempStrokes, new FlatMappingOperationImpl()
                    .flatMap(source[i]));
        }
        List<Integer> tempList = Stream.of(tempStrokes).parallel()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayList<Integer> listOfIntegers = new ArrayList<>(new HashSet<>(tempList));
        Collections.sort(listOfIntegers, Collections.reverseOrder());
        return listOfIntegers.parallelStream()
                .map((integers) -> integers.toString())
                .collect(Collectors.toList()).toArray(new String[0]);
    }
}