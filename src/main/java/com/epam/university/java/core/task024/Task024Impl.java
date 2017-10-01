package com.epam.university.java.core.task024;

import com.epam.university.java.core.Validator;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        new Validator().vaildate(source);
        final String pattern = "(?=\\p{Lu})";
        //        String sourceInUTF = decode(source, "UTF-8");
        //        List<String> strings = new LinkedList<>();
        //        Set<String> set = Charset.availableCharsets().keySet();
        //        for (String s : set) {
        //            strings.add(decode(sourceInUTF, s));
        //        }
        return source.isEmpty()
                ? Collections.emptyList()
                : Arrays.stream(source.split(pattern))
                .map(String::toLowerCase)
                //                .map(s -> decode(s, "windows-1251"))
                .collect(Collectors.toList());
    }

    private String decode(String source, String charsetName) {
        return new String(source.getBytes(), Charset.forName(charsetName));
    }
}
