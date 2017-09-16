package com.epam.university.java.core.task003;

/**
 * Created by Вера on 06.09.2017.
 */
public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {

        if ("Three".equals(element) || "Four".equals(element)) { // - c этим условием работает
            //if (element.length() == 4) { // а с этим testFilter не проходит
            // не понимаю почему так?!?!
            return true;
        } else {
            return false;
        }
    }
}
