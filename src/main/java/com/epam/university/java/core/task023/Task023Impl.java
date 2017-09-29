package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        if (phoneString.length() < 10) {
            throw new IllegalArgumentException();
        }
        Pattern p = Pattern.compile("\\+?([\\d]{1})\\s?\\(?([\\d]{3})\\)?");
        Matcher m = p.matcher(phoneString);
        m.find();
        return m.group(2);
    }
}
