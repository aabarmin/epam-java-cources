package com.epam.university.java.core.task023;

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

        if (phoneString == null) {
            throw new IllegalArgumentException();
        }

        phoneString = phoneString.replaceAll("[\\D]+", "");

        if (phoneString.length() == 11) {
            return phoneString.substring(1,4);
        } else {
            throw new IllegalArgumentException();
        }

    }
}
