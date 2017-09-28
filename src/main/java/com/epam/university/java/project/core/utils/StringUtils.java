package com.epam.university.java.project.core.utils;

/**
 * Utility class for String objects' routine.
 */
public final class StringUtils {

    private StringUtils() { }

    /**
     * Check if string is null.
     * @param s string to check
     * @return <code>true</code> if string is null else <code>false</code>
     */
    public static boolean isNull(String s) {
        return s == null;
    }

    /**
     * Check if string is not null.
     * @param s string to check
     * @return <code>true</code> if string is not null else <code>false</code>
     */
    public static boolean isNonNull(String s) {
        return !isNull(s);
    }

    /**
     * Check if string is empty (e.g. null or has zero length or consist of only spaces).
     * @param s string to check
     * @return <code>true</code> if string is empty else <code>false</code>
     */
    public static boolean isEmpty(String s) {
        return isNull(s) || s.isEmpty() || s.trim().isEmpty();
    }

    /**
     * Check if string is not empty (e.g. null or has zero length or consist of only spaces).
     * @param s string to check
     * @return <code>true</code> if string is not empty else <code>false</code>
     */
    public static boolean isNonEmpty(String s) {
        return !isEmpty(s);
    }

}
