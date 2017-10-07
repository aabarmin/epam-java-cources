package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task024Impl implements  Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("(.)(\\p{Lu})");
        Matcher matcher = pattern.matcher(source);
        source =matcher.replaceAll("$1!$2");


        return  Arrays.stream(source.split("!")).map(String::toLowerCase).filter(n->!"".equals(n)).collect(Collectors.toList());

    }
}
