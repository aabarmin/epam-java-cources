package com.epam.university.java.core.task003;

/**
 * Some docs.
 */
public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        if (element == null) {
            return false;
        } else if (element.equals("Three") || element.equals("Four")) {
            return true;
        } else {
            return false;
        }
    }
}
