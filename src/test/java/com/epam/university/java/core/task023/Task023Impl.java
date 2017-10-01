package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation class for Task022.
 *
 * @author Sergei Titov
 */
public class Task023Impl implements Task023 {

    final static String regExp =
            "(\\d\\d\\d)[ )-]*[\\d][ -]*[\\d][ -]*[\\d][ -]*[\\d][ -]*[\\d][ -]*[\\d][ -]*[\\d]$";

    /**
     * {@inheritDoc}
     */
    @Override
    public String extract(String phoneString) throws IllegalArgumentException {

        final Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(phoneString);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
