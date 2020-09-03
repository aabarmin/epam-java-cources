package com.epam.university.java.core.task023;

public class Task023Impl implements Task023 {

    @Override
    public String extract(String phoneString) {
        if (phoneString == null || phoneString.length() < 10) {
            throw new IllegalArgumentException();
        }
        return phoneString.replaceAll("[+(|)/\\s]", "").substring(1,4);
    }
}
