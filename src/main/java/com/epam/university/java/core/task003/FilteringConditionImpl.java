package com.epam.university.java.core.task003;

/**
 * implementation class for FilteringCondition.
 *
 * @author Sergei Titov
 */
public class FilteringConditionImpl implements FilteringCondition {

    /**
     * determines if the param satisfies to the rule.
     *
     * @param element element
     *
     * @return value is TRUE if element is satisfying
     */
    @Override
    public boolean isValid(String element) {

        if (element.length() > 3) {
            return true;
        }

        return false;
    }
}
