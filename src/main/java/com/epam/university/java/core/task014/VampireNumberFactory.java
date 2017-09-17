package com.epam.university.java.core.task014;

/**
 * Factory of vampire numbers.
 */
public interface VampireNumberFactory {
    /**
     * Create new vampire number instance.
     * @param multiplication multiplication value
     * @param first first part value
     * @param second second part value
     * @return new instance
     */
    VampireNumber newInstance(int multiplication, int first, int second);
}
