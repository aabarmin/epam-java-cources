package com.epam.university.java.core.task024;

import com.epam.university.java.core.utils.common.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class implements Task024.
 */
public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        Validator.validateNotNull(source, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        List<String> result = new ArrayList<>();
        String patternString = "(^\\p{Lu}?\\p{Ll}*)|(\\p{Lu}\\p{Ll}*)";
        Matcher matcher = Pattern.compile(patternString).matcher(source);
        while (matcher.find()) {
            for (int i = 1; i < 3; i++) {
                if (!(matcher.group(i) == null)) {
                    result.add(matcher.group(i).toLowerCase());
                }
            }
        }
        if (result.get(0) == "") {
            return Collections.emptyList();
        }
        return result;
    }
}