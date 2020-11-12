package com.epam.university.java.core.task061;

/**
 * Roman and arabic numbers converter.
 */
public interface Task061 {
    /**
     * Convert arabic number to roman.
     *
     * @param number arabic number
     * @return roman number
     * @throws IllegalArgumentException if number is smaller than 1 or greater than 3999
     */
    String convertToRoman(int number);

    /**
     * Convert roman number to arabic.
     *
     * @param number roman number
     * @return arabic number
     * @throws IllegalArgumentException if number contains non-valid symbols
     */
    int convertToArabic(String number);
}
