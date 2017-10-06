package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        ArrayList<String> result = new ArrayList<>();
        final Pattern p = Pattern.compile("\\p{Lower}+|\\p{Upper}\\p{Lower}+",
                Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher m = p.matcher(source);
        while (m.find()) {
            result.add(m.group(0).toLowerCase());
        }
        return result;
    }
}
