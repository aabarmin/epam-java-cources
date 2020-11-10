package com.epam.university.java.core.task045;

public class Task045Impl implements Task045 {
    @Override
    public String doAnagram(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.equals(" ")) {
            return " ";
        }
        String[] words = input.split(" ");
        String result = "";
        for (String word : words) {
            char[] chars = word.toCharArray();
            int len = chars.length;
            char[] anagram = new char[len];
            int cursor = len - 1;
            for (int i = 0; i < len; i++) {
                if (!Character.isAlphabetic(chars[i])) {
                    anagram[i] = chars[i];
                }
            }
            for (int i = 0; i < len; i++) {
                if (Character.isAlphabetic(chars[i])) {
                    while (anagram[cursor] != 0 && cursor > 0) {
                        cursor--;
                    }
                    anagram[cursor] = chars[i];
                }
            }
            result = result.concat(" ").concat(new String(anagram));

        }
        return result.trim();
    }
}
