package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 25.09.2017.
 */
public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        String regex = "^(8|\\+7) ?\\(?(\\d{3})\\)? ?(\\d{3}-? ?\\d{2}-?" +
                " ?\\d{2})$";
        Matcher matcher = Pattern.compile(regex).matcher(phoneString);
        if (matcher.find()) {
            return matcher.group(2);
        }
        throw new IllegalArgumentException(
                "Incorrect cell phone number format");
    }
}