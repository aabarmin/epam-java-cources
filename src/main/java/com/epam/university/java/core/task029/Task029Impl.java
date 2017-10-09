package com.epam.university.java.core.task029;

import java.util.Collection;

public class Task029Impl implements Task029 {

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        if (rows == null || words == null) {
            throw new IllegalArgumentException();
        }
        final Crossword crossword = new Crossword();
        crossword.fill(rows, words);
        return crossword.getCrossword();
    }
}