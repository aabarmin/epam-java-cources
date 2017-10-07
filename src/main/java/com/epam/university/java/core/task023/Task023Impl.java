package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {

        if (phoneString == null) {
            throw new IllegalArgumentException();
        }
        Pattern delimitersPattern = Pattern.compile("\\+|\\(|\\)|\\s|-");
        Matcher delimitersMatchers = delimitersPattern.matcher(phoneString);
        phoneString = delimitersMatchers.replaceAll("");
        if (phoneString.length() != 11) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("\\d(\\d{3})");
        Matcher matcher = pattern.matcher(phoneString);
        if (matcher.find()) {
            if (matcher.group(1) != null) {
                return matcher.group(1);
            }
        }
        return null;
    }
}
