package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        if (element.equals("One") || element.equals("Two")) {
            return false;
        }
        return true;
    }
}