package com.epam.university.java.core.task003;

/**
 * Created by Александр on 14.09.2017.
 *
 * <p>Class for filter Strings with length < 3
 */
public class FilteringConditionImpl implements FilteringCondition {
    /**
     * Check if element satisfies condition.
     *
     * @param element element
     * @return is satisfied, or false if element not provided
     */
    @Override
    public boolean isValid(String element) {
        return (element.length() > 3);
    }
}
