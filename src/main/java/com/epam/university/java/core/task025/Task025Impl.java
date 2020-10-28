package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }

        int amountOfChanges = 0;

        char[] sos = {'S', 'O', 'S'};
        char[] message = sourceMessage.toCharArray();

        int index = 0;

        for (int i = 0; i < message.length; i++) {
            if (message[i] != sos[index]) {
                amountOfChanges++;
            }
            index++;
            if (index > 2) {
                index = 0;
            }
        }
        return amountOfChanges;
    }
}
