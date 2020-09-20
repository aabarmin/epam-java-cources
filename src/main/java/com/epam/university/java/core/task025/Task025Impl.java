package com.epam.university.java.core.task025;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }
        if (sourceMessage.isEmpty()) {
            return 0;
        }

        List<Character> listToCompare = new ArrayList<>();
        if (sourceMessage.length() % 3 == 0) {
            for (int i = 0; i < sourceMessage.length() / 3; i++) {
                listToCompare.add('S');
                listToCompare.add('O');
                listToCompare.add('S');
            }
        } else {
            if (sourceMessage.length() % 3 == 1) {
                for (int i = 0; i < sourceMessage.length() / 3; i++) {
                    listToCompare.add('S');
                    listToCompare.add('O');
                    listToCompare.add('S');
                }
                listToCompare.add('S');
            }
            if (sourceMessage.length() % 3 == 2) {
                for (int i = 0; i < sourceMessage.length() / 3; i++) {
                    listToCompare.add('S');
                    listToCompare.add('O');
                    listToCompare.add('S');
                }
                listToCompare.add('S');
                listToCompare.add('O');
            }
        }

        char[] myChar = sourceMessage.toCharArray();
        int count = 0;

        for (int i = 0; i < myChar.length; i++) {
            if (myChar[i] != listToCompare.get(i)) {
                count++;
            }
        }
        return count;
    }
}
