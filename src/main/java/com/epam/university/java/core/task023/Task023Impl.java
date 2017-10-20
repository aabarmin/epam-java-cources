package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        Pattern p = Pattern.compile("[9][0-9]{2}");
        Matcher m = p.matcher(phoneString);

        if (!phoneString.matches(
                "^\\+?[7|8]\\s?\\(?[0-9]{3}\\)?\\s?[0-9]{3}[-?\\s]?[0-9]{2}[-?|\\s]?[0-9]{2}$")) {
            throw new IllegalArgumentException();
        } else {
            if (m.find()) {
                return phoneString.substring(m.start(), m.end());
            }
        }
        return null;
    }
}
