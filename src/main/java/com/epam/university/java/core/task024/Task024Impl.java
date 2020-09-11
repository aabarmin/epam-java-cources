package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Romin Nuro on 28.08.2020 0:00.
 */
public class Task024Impl implements Task024 {
    /**
     * Given a string with camel case word, you should separate this string
     * into collection of words.
     *
     * <p>
     * Example: source string is saveChangesInTheEditor, result is
     * [save, changes, in, the, editor]
     * </p>
     *
     * @param source source string
     * @return collection of words
     */
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("(^[a-zа-я]+|[A-ZА-ЯÄÖÜ][a-zа-я]+)");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            words.add(source.substring(matcher.start(), matcher.end()).toLowerCase());
        }
        return words;
    }
}
