package com.epam.university.java.core.task023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author Dmitry Novikov 02-Sep-20.
 */
public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        if (phoneString == null) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("(?<=\\().+?(?=\\))");
        Matcher matcher = pattern.matcher(phoneString);
        String result = null;
        StringBuilder myString;

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            result = phoneString.substring(start, end);
        }

        if (result == null) {
            List<Character> list = new ArrayList<>();
            char[] dd = phoneString.toCharArray();
            for (char c : dd
            ) {
                if (Character.isDigit(c)) {
                    list.add(c);
                }
            }
            if (list.size() != 11) {
                System.out.println("less than 11");
                throw new IllegalArgumentException();
            }

            myString = new StringBuilder();
            myString.append(list.get(1));
            myString.append(list.get(2));
            myString.append(list.get(3));

            System.out.println(myString.toString());
        } else {
            return result;
        }
        return myString.toString();
    }
}