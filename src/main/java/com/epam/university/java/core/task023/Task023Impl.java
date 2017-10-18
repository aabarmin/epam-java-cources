package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@inheritDoc}
 */
public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        Pattern code = Pattern.compile(
                "^\\+?[\\d]\\s?\\(?([\\d]{3})\\)?\\s?[\\d]{3}[-|\\s]?[\\d]{2}[-|\\s]?[\\d]{2}");
        Matcher matcher = code.matcher(phoneString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        return matcher.group(1);
    }
}
