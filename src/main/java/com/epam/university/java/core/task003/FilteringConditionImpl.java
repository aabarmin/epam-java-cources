package com.epam.university.java.core.task003;

public final class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(final String element) {
        return !("One".equals(element) || ("Two".equals(element)));
    }
}
