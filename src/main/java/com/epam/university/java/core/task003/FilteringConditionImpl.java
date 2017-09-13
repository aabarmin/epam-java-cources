package com.epam.university.java.core.task003;

/**
 * Implementation of the string array filtering condition.
 */
public class FilteringConditionImpl implements FilteringCondition {

    private static final int MIN_LENGTH = 4;

    /**
     * Check if element length is greater than or equal to @{MIN_LENGTH}.
     *
     * @param element element
     * @return if element satisfies condition or false if element not provided
     */
    @Override
    public boolean isValid(String element) {
        return element != null && element.length() >= MIN_LENGTH;
    }

}
