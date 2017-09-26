package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {

        Pattern pattern = Pattern.compile(
                "((\\+7)|8)[ -]?\\(?([0-9]{3})\\)?[ -]?[0-9]{3}[ -]?[0-9]{2}[ -]?[0-9]{2}"
        );
        Matcher matcher = pattern.matcher(phoneString);

        if (matcher.find()) {
            return matcher.group(3);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
