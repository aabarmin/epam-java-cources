package com.epam.university.java.core.task025;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage.isEmpty()) {
            return 0;
        }
        char[] myChar = sourceMessage.toCharArray();
        int count = 0;

        for (int i = 0; i < myChar.length; i += 3) {
            if (myChar[i] != 'S') {
                count++;
            }
            if (myChar[i + 1] != 'O') {
                count++;
            }
            if (myChar[i + 2] != 'S') {
                count++;
            }
        }

        return count;
    }
}
