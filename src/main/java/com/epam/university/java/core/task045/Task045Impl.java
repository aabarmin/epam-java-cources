package com.epam.university.java.core.task045;

public class Task045Impl implements Task045 {
    @Override
    public String doAnagram(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.isBlank() || input.isEmpty()) {
            return input;
        }

        StringBuilder output = new StringBuilder();
        String[] words = input.split(" ");
        int iteration = 0;
        for (String word : words) {
            int length = word.length();
            char[] reversedWord = new char[length];
            StringBuilder reversedWordBuilder = new StringBuilder();
            for (int i = 0; i < reversedWord.length; i++) {
                char currentChar = word.charAt(i);
                if (!Character.isAlphabetic(currentChar)) {
                    reversedWord[i] = currentChar;
                } else {
                    reversedWordBuilder.append(currentChar);
                }
            }

            for (int i = reversedWord.length - 1; i >= 0; i--) {
                if (reversedWord[i] != word.charAt(i)) {
                    reversedWord[i] = reversedWordBuilder.charAt(0);
                    reversedWordBuilder.delete(0, 1);
                }
            }
            if (iteration < words.length - 1) {
                output.append(reversedWord).append(" ");
            } else {
                output.append(reversedWord);
            }
            iteration++;
        }

        return output.toString();
    }
}
