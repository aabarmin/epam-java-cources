package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage.length() % 3 != 0) {
            throw new IllegalArgumentException("Invalid string.");
        }

        int count = 0;
        for (int i = 0; i < sourceMessage.length(); i += 3) {
            String sosString = sourceMessage.substring(i, i + 3);
            
            if (sosString.charAt(0) != 'S') {
                count++;
            }
            if (sosString.charAt(1) != 'O') {
                count++;
            }
            if (sosString.charAt(2) != 'S') {
                count++;
            }
        }

        return count;
    }
}
