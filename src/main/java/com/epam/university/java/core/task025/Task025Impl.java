package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage.length() % 3 != 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder target = new StringBuilder();
        for (int i = 0; i < sourceMessage.length() / 3; i++) {
            target.append("SOS");
        }

        int counter = 0;

        for (int i = 0; i < sourceMessage.length(); i++) {
            if (sourceMessage.charAt(i) != target.charAt(i)) {
                counter++;
            }
        }

        return counter;
    }
}
