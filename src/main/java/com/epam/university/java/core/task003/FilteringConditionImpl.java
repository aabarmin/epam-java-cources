package com.epam.university.java.core.task003;

/**
 * FilteringCondition implementation.
 */
public final class FilteringConditionImpl implements FilteringCondition {

    /**
     * Words shorter than 4 chars are invalid.
     */
    private static final int MIN_CHARS = 4;

    @Override
    public boolean isValid(final String element) {
        return (element.length() >= MIN_CHARS);
    }
}
