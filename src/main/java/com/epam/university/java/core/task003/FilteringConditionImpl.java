package com.epam.university.java.core.task003;

/**
 * FilteringCondition implementation.
 */
public final class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(final String element) {
        return (element.length() > 3);
    }
}
