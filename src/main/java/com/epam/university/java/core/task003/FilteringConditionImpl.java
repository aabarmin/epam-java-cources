package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        if (element.length() > 3) {
            return true;
        } else {
            return false;
        }

    }
}
