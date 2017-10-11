package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilya on 25.09.17.
 */
public class Task023Impl implements Task023 {

    @Override
    public String extract(String phoneString) {
        Pattern pattern = Pattern.compile(
            "\\+?\\d\\s?(\\s|\\()?(\\d{3})(\\s|\\))?\\s?\\d{3}((\\s|-)?\\d{2}){2}"
        );

        Matcher matcher = pattern.matcher(phoneString);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Incorrect format");
        }

        return matcher.group(2);
    }
}
