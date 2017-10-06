package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation class for Task024.
 *
 * @author Sergei Titov
 */
public class Task024Impl implements Task024 {

    private static final String regExp = "([\\w][^\\p{Lu}]*)";

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> getWordsCount(String source) {

        Collection<String> collection = new ArrayList<>();

        final Pattern pattern = Pattern.compile(regExp, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(source);

        while (matcher.find()) {
            collection.add(matcher.group(0).toLowerCase());
        }
        return collection;
    }
}
