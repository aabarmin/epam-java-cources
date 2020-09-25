package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {

    @Override
    public String extract(String phoneString) {

        if (phoneString == null || phoneString.length() < 9) {
            throw new IllegalArgumentException();
        }
        phoneString = phoneString.replace(" ", "");
        String code = null;
        if (phoneString.contains("(")) {
            Pattern pattern = Pattern.compile("(\\d{3})");
            Matcher matcher = pattern.matcher(phoneString);
            if (matcher.find()) {
                code = phoneString.substring(matcher.start(), matcher.end());
            }
        } else {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(phoneString);
            if (matcher.find()) {
                code = phoneString.substring(matcher.start() + 1, matcher.start() + 4);
            }
        }
        return code;
    }
}
