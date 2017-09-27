package com.epam.university.java.core.task023;

/**
 * Created by Daniil Smirnov on 26.09.2017.
 * All copy registered MF.
 */
public class Task023Impl implements Task023 {

    @Override
    public String extract(String phoneString) {
        String[] b = phoneString.split("\\D");
        StringBuilder sb = new StringBuilder();
        for (String s : b) {
            if (!s.isEmpty()) {
                sb.append(s);
            }
        }
        if (sb.length() <= 10) {
            throw new IllegalArgumentException();
        }

        return sb.substring(1,4);
    }
}
