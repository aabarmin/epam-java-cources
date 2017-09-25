package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regular expressions.
 */
public class Task023Impl implements Task023 {

    /**
     * Given string that presents cell phone number. You should use regular expression
     * to extract operator code.
     *
     * <p>
     *     Example: given phone number +7(912)345-67-89, operator code is 912
     * </p>
     *
     * @param phoneString cell phone number string
     * @return operator code string
     */
    @Override
    public String extract(String phoneString) {
        final StringBuilder sb = new StringBuilder("^"); // match from the beginning
        // start with '8' or '+7', then maximum one dash or space. this must be found exactly once
        sb.append("((8|\\+7)[\\- ]?){1}");
        // 3 digits that might be inside of parentheses followed by maximum one dash or space
        sb.append("(\\(?(\\d{3}){1}\\)?[\\- ]?){1}");
        // 3 digits followed by maximum one dash or space. this must be found exactly once
        sb.append("((\\d{3}){1}[\\- ]?){1}");
        // pair of 2 digits separated by maximum one dash or space. this must be found exactly once
        sb.append("((\\d{2}){1}[\\- ]?(\\d{2}){1}){1}");
        sb.append("$");
        final Pattern pattern = Pattern.compile(sb.toString());
        final Matcher matcher = pattern.matcher(phoneString);
        if (matcher.find()) {
            return matcher.group(4); // operator code
        }
        throw new IllegalArgumentException();
    }

}
