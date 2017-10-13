package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        Pattern p = Pattern.compile("^(8|\\+7[ ]?)?(\\(?(\\d{3})\\)?)?[\\d\\- ]{7,10}$");
        Matcher m = p.matcher(phoneString);

        if (!m.matches() || phoneString.length() < 11) {
            throw new IllegalArgumentException("Invalid phone number.");
        }

        return m.group(3);
    }
}