package com.epam.university.java.core.task003;

/**
 * String array filtering condition.
 */
public interface FilteringCondition {
    /**
     * Check if element satisfies condition.
     *
     * @param element element
     * @return is satisfied, or false if element not provided
     */
    boolean isValid(String element);
}

