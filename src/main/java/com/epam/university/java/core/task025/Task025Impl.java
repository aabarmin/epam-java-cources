package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException("String wasn't provided!");
        }
        final String sos = "SOS";
        final String[] sosStrings = sourceMessage.split("(?<=\\G.{3})");
        int count = 0;
        for (String sosString : sosStrings) {
            for (int i = 0; i < sosString.length(); i++) {
                if (sos.charAt(i) != sosString.charAt(i)) {
                    count++;
                }
            }
            count += sos.length() - sosString.length();
        }
        return count;
    }
}