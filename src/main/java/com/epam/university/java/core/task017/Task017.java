package com.epam.university.java.core.task017;

/**
 * Formatting.
 */
public interface Task017 {
    /**
     * Output objects as formatted string.
     * @param args objects to output
     * @return formatted string
     */
    String formatString(Object... args);

    /**
     * Output objects as formatted string.
     * @param args objects to output
     * @return formatted string
     */
    String formatNumbers(Object... args);

    /**
     * Output objects as formatted string.
     * @param args objects to output
     * @return formatted string
     */
    String formatDates(Object... args);
}
