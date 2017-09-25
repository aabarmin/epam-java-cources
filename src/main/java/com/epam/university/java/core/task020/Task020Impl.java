package com.epam.university.java.core.task020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Daniil Smirnov on 25.09.2017.
 * All copy registered MF.
 */
public class Task020Impl implements Task020 {

    @Override
    public int calculate(Collection<String> stones) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(stones);
        int count = 0;

        for (String s: list.get(0).split("")) {
            int badMatcher = 0;
            for (String t : list) {
                Pattern p = Pattern.compile(s);
                Matcher m = p.matcher(t);
                if (!m.find()) {
                    badMatcher++;
                }
            }
            if (badMatcher == 0) {
                count++;
            }
        }

        return count;
    }
}
