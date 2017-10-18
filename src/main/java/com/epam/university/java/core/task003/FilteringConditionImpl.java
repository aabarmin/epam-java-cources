package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        boolean result = false;
        if (element.length() > 3) {
            result = true;
        }
        return result;
    }
}
