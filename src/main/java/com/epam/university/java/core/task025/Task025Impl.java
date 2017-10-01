package com.epam.university.java.core.task025;

/**
 * Created by Вера on 01.10.2017.
 */
public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        char[] chars = sourceMessage.toCharArray();
        int mistake = 0;

        for (int i = 0; i < chars.length; i++) {
            if ((i + 3) % 3 == 0 || (i + 3) % 3 == 2) {
                if (chars[i] != 'S') {
                    mistake++;
                }
            }

            if ((i + 3) % 3 == 1) {
                if (chars[i] != 'O') {
                    mistake++;
                }
            }
        }

        return mistake;
    }
}
