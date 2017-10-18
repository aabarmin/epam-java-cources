package com.epam.university.java.core.task024;

import java.util.Collection;
import java.util.LinkedList;

/**
 * {@inheritDoc}
 */
public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        LinkedList<String> result = new LinkedList<>();
        if (source.length() == 0) {
            return result;
        }
        for (String w : source.split("(?=\\p{Lu})")) {
            result.add(w.toLowerCase());
        }
        return result;
    }
}
