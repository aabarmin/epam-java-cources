package com.epam.university.java.core.task020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {

        if (stones == null || stones.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> list = new ArrayList<>(stones);
        int collisionAmount = 0;
        char[] letters = list.get(0).toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char checkChar = letters[i];
            int wordsContain = 1;

            for (int j = 1; j < list.size(); j++) {
                char[] word = list.get(j).toCharArray();

                if (containsLetter(word, checkChar)) {
                    wordsContain++;
                }
                list.add(j, Arrays.toString(word));
                list.remove(j + 1);

            }

            if (wordsContain == list.size()) {
                collisionAmount++;
            }
        }


        return collisionAmount;
    }

    private boolean containsLetter(char[] word, char checkChar) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == checkChar) {
                word[i] = ' ';
                return true;
            }
        }
        return false;
    }
}
