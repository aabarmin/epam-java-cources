package com.epam.university.java.core.task003;

/**
 * Created by Doomsday Device on 17.09.2017.
 */
public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        if (element.length() < 4) {
            return false;
        }
        return true;
    }
}
