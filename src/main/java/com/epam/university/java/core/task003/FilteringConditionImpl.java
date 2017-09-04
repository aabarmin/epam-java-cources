package com.epam.university.java.core.task003;

/**
 * Created by Dremina on 03.09.2017.
 */
public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        if (element.length() > 3){
            return true;
        }
        return false;
    }
}
