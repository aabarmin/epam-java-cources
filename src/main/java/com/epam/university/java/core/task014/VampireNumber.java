package com.epam.university.java.core.task014;

/**
 * Vampire number holder interface.
 */
public interface VampireNumber {
    /**
     * Get multiplication of numbers.
     * @return value of multiplication
     */
    int getMultiplication();

    /**
     * Get first part of vampire number.
     * @return value of the first part
     */
    int getFirst();

    /**
     * Get second part of vampire number.
     * @return value of the second part
     */
    int getSecond();

    /**
     * Check if two vampire numbers are equals in spite of the order
     * of parts.
     * @param value vampire number to check
     * @return if numbers are equals
     */
    boolean equals(Object value);
}
