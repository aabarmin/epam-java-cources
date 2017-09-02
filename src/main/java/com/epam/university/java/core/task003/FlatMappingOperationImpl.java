package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ilya on 02.09.17.
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        List<String> stringList = Arrays.asList(source.split(","));
        List<String> resultList = new ArrayList<>();
        String[] result = new String[0];

        for (String string :
                stringList) {
            resultList.add(string.trim());
        }


        return resultList.toArray(result);
    }
}
