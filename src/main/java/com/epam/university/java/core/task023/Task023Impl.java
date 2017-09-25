package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Александр on 26.09.2017.
 */
public class Task023Impl implements Task023 {
    /**
     * Given string that presents cell phone number. You should use regular expression
     * to extract operator code.
     * <p>
     * <p>
     * Example: given phone number +7(912)345-67-89, operator code is 912
     * </p>
     *
     * @param phoneString cell phone number string
     * @return operator code string
     */
    @Override
    public String extract(String phoneString) {
        Pattern pattern = Pattern.compile("^(8|\\+7)? ?\\(?(\\d{3})\\)?[\\d- ]{7,10}");
        Matcher matcher = pattern.matcher(phoneString);
        if (matcher.matches()) {
            return matcher.group(2);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
