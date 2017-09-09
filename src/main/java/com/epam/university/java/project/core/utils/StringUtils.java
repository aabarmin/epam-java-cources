package com.epam.university.java.project.core.utils;

/**
 * @author ABarmin
 */
public class StringUtils {
    public static final boolean isEmpty(final String source) {
        return source == null ||
                source.isEmpty() ||
                source.trim().isEmpty();
    }

    public static final boolean isNotEmpty(final String source) {
        return !isEmpty(source);
    }
}
