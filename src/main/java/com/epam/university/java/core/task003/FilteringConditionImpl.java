package com.epam.university.java.core.task003;

/**
 * Created by Mirabilis on 03.09.2017.
 */
public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        if (element == null) {
            return false;
        }
        if (element.length() < 4) {
            return false;
        }
        return true;
    }
}
