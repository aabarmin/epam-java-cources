package com.epam.university.java.core.task049;

public class Task049Impl implements Task049 {
    @Override
    public String getResultList(String first, String second) {
        if (first == null || second == null || first.isBlank() || second.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (first.equals(second)) {
            return first;
        }

        if (second.length() > first.length()) {
            String tmp = second;
            second = first;
            first = tmp;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < second.length(); i++) {
            if (first.contains(stringBuilder)) {
                stringBuilder.append(second.charAt(i));
            } else {
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                break;
            }

        }
        int beginIndex = first.indexOf(stringBuilder.toString());
        return first.substring(beginIndex, beginIndex + stringBuilder.length());
    }
}
