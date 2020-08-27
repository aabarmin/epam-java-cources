package com.epam.university.java.core.task023;

import java.util.regex.Pattern;

/**
 * Created by Romin Nuro on 27.08.2020 22:57.
 */
public class Task023Impl implements Task023 {
    /**
     * Given string that presents cell phone number. You should use regular expression
     * to extract operator code.
     *
     * <p>
     * Example: given phone number +7(912)345-67-89, operator code is 912
     * </p>
     *
     * @param phoneString cell phone number string
     * @return operator code string
     */
    @Override
    public String extract(String phoneString) {
        if (phoneString.length() < 11) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("\\D");
        String[] digits = pattern.split(phoneString);
        return String.join("", digits).substring(1,4);
    }
}
