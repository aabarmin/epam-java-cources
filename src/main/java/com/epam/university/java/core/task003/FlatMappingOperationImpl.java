package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

/**
 * FlatMappingOperation implementation.
 */
public final class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(final String source) {
        String s = source.replaceAll("\\s", "");
        String[] stringArray = s.split(",");

        Set<Integer> intSet = new TreeSet<>();
        for (String str : stringArray) {
            intSet.add(Integer.parseInt(str));
        }

        List<Integer> intList = new ArrayList<>();
        intList.addAll(intSet);

        Collections.sort(intList, Collections.reverseOrder());

        List<String> resultStringList = new ArrayList<>();
        for (int i : intList) {
            resultStringList.add(Integer.toString(i));
        }

        String[] resultArray = new String[resultStringList.size()];
        resultArray = resultStringList.toArray(resultArray);

        return resultArray;
    }
}
