package com.epam.university.java.core.task023;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        String result = phoneString.replaceAll("[+ .,!?/'();:-]+", "");
        if (result.length() != 11) {
            throw new IllegalArgumentException();
        }
        result = result.substring(1, 4);
        return result;
    }
}
