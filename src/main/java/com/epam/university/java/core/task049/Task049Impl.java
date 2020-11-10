package com.epam.university.java.core.task049;

public class Task049Impl implements Task049 {
    @Override
    public String getResultList(String first, String second) {
        if (first == null || second == null || first.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        String result = "";
        for (int len = 1; len <= first.length(); len++) {
            for (int i = 0; i <= first.length() - len; i++) {
                String substring = first.substring(i, i + len);
                if (second.contains(substring)) {
                    result = substring;
                }
            }
        }
        return result;
    }
}