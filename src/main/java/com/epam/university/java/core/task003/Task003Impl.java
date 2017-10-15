package com.epam.university.java.core.task003;

import com.epam.university.java.core.Validator;

import java.util.Arrays;
import java.util.List;

public class Task003Impl implements Task003 {
    private Validator validator = Validator.getInstance();

    @Override
    public String[] invert(String[] source) {
        validator.validate((Object[]) source);
        String[] result = new String[source.length];
        int j = 0;
        for (int i = source.length - 1; i >= 0; i--, j++) {
            result[j] = source[i];
        }
        return result;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        validator.validate(first, second);
        final String[] result = new String[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }


    @Override
    public int findMax(int[] source) {
        validator.validate((Object) source);
        return Arrays.stream(source)
                .max()
                .getAsInt();
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        validator.validate(source, condition);
        return Arrays.stream(source)
                .filter(condition::isValid)
                .toArray(String[]::new);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        validator.validate(source, toRemote);
        final List<String> listToRemote = Arrays.asList(toRemote);
        return Arrays.stream(source)
                .filter(s -> !listToRemote.contains(s))
                .toArray(String[]::new);
    }


    @Override
    public String[] map(String[] source, MappingOperation operation) {
        validator.validate(source, operation);
        return Arrays.stream(source)
                .map(operation::map)
                .toArray(String[]::new);
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        validator.validate(source, operation);
        final String[] fullArray = Arrays.stream(source)
                .flatMap(s -> Arrays.stream(operation.flatMap(s)))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sorted()
                .distinct()
                .mapToObj(Integer::toString)
                .toArray(String[]::new);
        return invert(fullArray);
    }
}
