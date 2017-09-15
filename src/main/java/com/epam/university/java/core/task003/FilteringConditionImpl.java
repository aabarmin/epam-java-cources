package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        if (element != null && element.length() >= 4) {
            return true;
        }
        return false;
    }
}
