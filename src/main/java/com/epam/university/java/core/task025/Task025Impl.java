package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        int count = 0;
        String etalon = "SOS";
        for (int i = 0; i < sourceMessage.length(); i++) {
            if (sourceMessage.charAt(i) != etalon.charAt(i % etalon.length())) {
                count++;
            }
        }
        return count;
    }
}
