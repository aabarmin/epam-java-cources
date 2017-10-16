package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;

public class Task029Impl implements Task029 {
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        if (rows == null || words == null) {
            throw new IllegalArgumentException("Data wasn't provided.");
        }
        CrosswordFilling cF = new CrosswordFilling();
        cF.fillCrossword(new ArrayList<>(rows), new ArrayList<>(words));
        return cF.getCrossword();
    }
}