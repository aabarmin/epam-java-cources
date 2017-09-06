package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        if(element=="One"|element=="Two"|element==null){
            return false;
        }
        return true;
    }
}