package com.epam.university.java.core.task003;

/**
 * Created by A.Sluzhbin on 23.08.2020
 */

public class FilteringConditionImpl implements FilteringCondition {

    @Override
    public boolean isValid(String element) {
        return (element.length() > 3);
    }
}
