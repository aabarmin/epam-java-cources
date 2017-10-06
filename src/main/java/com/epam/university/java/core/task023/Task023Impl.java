package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        String rusPhoneNumber =
                "\\+?(\\d)\\s?\\(?(\\d{3})\\)?\\s?(\\d{3})[\\-\\s]?(\\d{2})[\\-\\s]?(\\d{2})";
        Pattern pattern = Pattern.compile(rusPhoneNumber);
        Matcher matcher = pattern.matcher(phoneString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Incorrect phone number format!");
        }
        return matcher.group(2);
    }
}