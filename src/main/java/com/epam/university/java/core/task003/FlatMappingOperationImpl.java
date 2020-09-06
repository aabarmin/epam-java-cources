package com.epam.university.java.core.task003;

/**
 * Created by A.Sluzhbin on 23.08.2020
 */

public class FlatMappingOperationImpl implements FlatMappingOperation {

    @Override
    public String[] flatMap(String source) {
        if (source == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        String[] words = source.replaceAll("\\s+", "").split(",");
        return words;
    }


}
