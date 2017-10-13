package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        checkArguments(first, second);

        List<String> result = new ArrayList<>();

        for (String i : first) {
            for (String j : second) {
                if (i.equals(j)) {
                    result.add(j);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    @Override
    public String[] union(String[] first, String[] second) {
        checkArguments(first, second);

        Set<String> result = new LinkedHashSet<>();

        result.addAll(Arrays.asList(first));
        result.addAll(Arrays.asList(second));

        return result.toArray(new String[0]);
    }

    private void checkArguments(String[] firstArg, String[] secondArg) {
        if (firstArg == null || secondArg == null) {
            throw new IllegalArgumentException();
        }
    }
}
