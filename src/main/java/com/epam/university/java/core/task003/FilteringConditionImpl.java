package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {

    private final String condition = "Last 2";

    @Override
    public boolean isValid(String element) {
        if (element == null) {
            return false;
        }
        if (condition.equals(element)) {
            return true;
        }

        return false;
    }
}