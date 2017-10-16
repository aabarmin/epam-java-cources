package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\p{Lu}?[^\\p{Lu}]*", Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            words.add(matcher.group().toLowerCase());
        }
        words.removeAll(Collections.singleton(""));
        return words;
    }
}
