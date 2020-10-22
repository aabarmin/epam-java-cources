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

        Pattern pattern = Pattern.compile("9\\d{2}");
        Matcher matcher = pattern.matcher(phoneString);
        if (matcher.find()) {
            code = phoneString.substring(matcher.start(), matcher.end());
        }

        return code;
    }
}
