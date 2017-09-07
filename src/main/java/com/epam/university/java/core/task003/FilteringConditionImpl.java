package com.epam.university.java.core.task003;

/**
 * Created by Вера on 06.09.2017.
 */
public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {

        if ("Three".equals(element) || "Four".equals(element))
            return true;
        else
            return false;
    }
}
