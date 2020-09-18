package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;

public class Task029Impl implements Task029 {
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        ArrayList<String> crossWord = new ArrayList<>(rows);
        for (String word:words) {
            System.out.println(word);
        }

        return crossWord;
    }
}
