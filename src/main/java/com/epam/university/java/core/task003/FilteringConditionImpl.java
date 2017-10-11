package com.epam.university.java.core.task003;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilya on 02.09.17.
 */
public class FilteringConditionImpl implements FilteringCondition {
    private static final Set<String> conditionalStrings = new HashSet<>();

    static {
        Collections.addAll(conditionalStrings, "Three", "Four");
    }

    @Override
    public boolean isValid(String element) {
        return conditionalStrings.contains(element);
    }
}
