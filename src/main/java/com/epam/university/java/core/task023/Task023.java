package com.epam.university.java.core.task023;

/**
 * Regular expressions.
 */
public interface Task023 {
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
    String extract(String phoneString);
}
