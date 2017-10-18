package com.epam.university.java.core.task024;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Daniil Smirnov on 27.09.2017.
 * All copy registered MF.
 */
public class Task024Impl implements Task024 {

    @Override
    public Collection<String> getWordsCount(String source) {

        if (source.isEmpty()) {
            return Collections.emptyList();
        }

        String s = source.replaceAll("(\\p{L})(\\p{Lu})", "$1,$2").toLowerCase();


        return Arrays.asList(s.split(","));
    }
}
