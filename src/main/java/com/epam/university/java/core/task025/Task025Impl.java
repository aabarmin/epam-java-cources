package com.epam.university.java.core.task025;

/**
 * Created by Daniil Smirnov on 28.09.2017.
 * All copy registered MF.
 */
public class Task025Impl implements Task025 {

    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {

        if (sourceMessage.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < sourceMessage.length(); i += 3) {
            String subString = sourceMessage.substring(i, i + 3);
            if (subString.charAt(0) != 'S') {
                count++;
            }
            if (subString.charAt(1) != 'O') {
                count++;
            }
            if (subString.charAt(2) != 'S') {
                count++;
            }
        }

        return count;

    }
}
