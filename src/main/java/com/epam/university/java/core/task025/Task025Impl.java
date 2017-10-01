package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage.length() == 0) {
            return 0;
        }
        final String sample = "SOS";

        String[] letters = sourceMessage.split("");

        int result = 0;
        int k;
        for (int i = 0; i < letters.length; i++) {
            k = i % 3;
            if (!letters[i].equals(Character.toString(sample.charAt(k)))) {
                result++;
            }
        }

        return result;

    }
}
