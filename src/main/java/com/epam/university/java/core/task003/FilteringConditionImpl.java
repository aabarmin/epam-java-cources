package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {
    /**
     * Check if element satisfies condition.
     *
     * @param element element
     * @return is satisfied, or false if element not provided
     */
    @Override
    public boolean isValid(String element) {
        if (element.equals("Three") || element.equals("Four")) {
            return true;
        }
        return false;
    }
}
