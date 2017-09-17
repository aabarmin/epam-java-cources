package com.epam.university.java.core.util;

/**
 * Just a class for some help with regular expressions.
 */
public final class RegexHelper {
    /**
     * Private constructor, not meant to be instantiated.
     */
    private RegexHelper() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Regular expression that filters chars, that cannot
     * be a part of the word.
     */
    public static final String REGEX_NON_WORDS = "[^A-Za-z0-9\\-]";

}



