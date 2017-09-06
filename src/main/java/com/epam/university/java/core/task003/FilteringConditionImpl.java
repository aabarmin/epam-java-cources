package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {

    private final String CONDITION = "Last 2";
    @Override
    public boolean isValid(String element) {
        if (element==null){
            return false;
        }
        if (CONDITION.equals(element))
            return true;

        return false;
    }
}
