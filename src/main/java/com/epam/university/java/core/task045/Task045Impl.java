package com.epam.university.java.core.task045;

import java.util.ArrayList;
import java.util.List;

public class Task045Impl implements Task045 {
    @Override
    public String doAnagram(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.matches("\\s*")) {
            return input;
        }
        String[] arrayOfWords = input.split("\\s");
        String result = "";


        for (int i = 0; i < arrayOfWords.length; i++) {
            char[] letters = arrayOfWords[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            List<Character> listOfLetters = new ArrayList<>();

            // Creating empty list with the checking word length size.
            // All places are filled with "null" for the next actions.
            for (int j = 0; j < letters.length; j++) {
                listOfLetters.add(null);
            }

            // Checking for the non-letter symbols.
            // If true, should be placed at the same place.
            for (int j = 0; j < letters.length; j++) {
                if (!Character.isLetter(letters[j])) {
                    listOfLetters.set(j, letters[j]);
                }
            }

            // Checking for the letter symbols.
            // If true, should be placed at the nearest "null" place
            // at the listOfLetters from the end.
            for (int j = 0; j < letters.length; j++) {
                if (Character.isLetter(letters[j])) {
                    int k = letters.length - 1;
                    for (int l = k; l >= 0; l--) {
                        if (listOfLetters.get(l) == null) {
                            listOfLetters.set(l, letters[j]);
                            break;
                        }
                    }

                }
            }
            for (Character ch :
                    listOfLetters) {
                sb.append(ch);
                System.out.println(sb.toString());
            }
            String reversedWord = sb.toString();
            result += reversedWord + " ";
        }
        return result.trim();
    }
}
