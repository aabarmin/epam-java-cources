package com.epam.university.java.core.task026;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task026Impl implements Task026 {
    private static final List<Character> alphabet = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    private static final List<Character> alphabetUpperCase = alphabet
            .stream()
            .map(Character::toUpperCase)
            .collect(Collectors.toList());

    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        String encryptedWord = "";
        char[] chars = sourceString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] + "").matches("[a-z]")) {
                int index = alphabet.indexOf(chars[i]);
                encryptedWord += alphabet.get((index + shift) % alphabet.size());
            } else if ((chars[i] + "").matches("[A-Z]")) {
                int index = alphabetUpperCase.indexOf(chars[i]);
                encryptedWord += alphabetUpperCase.get((index + shift)
                        % alphabetUpperCase.size());
            } else {
                encryptedWord += chars[i];
            }
        }
        return encryptedWord;
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        if (encryptedString == null) {
            throw new IllegalArgumentException();
        }
        String decryptedWord = "";
        char[] chars = encryptedString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] + "").matches("[a-z]")) {
                int index = alphabet.indexOf(chars[i]);
                int newIndex = index - shift;
                while (newIndex < 0) {
                    newIndex = alphabet.size() + newIndex;
                }
                decryptedWord += alphabet.get(newIndex);
            } else if ((chars[i] + "").matches("[A-Z]")) {
                int index = alphabetUpperCase.indexOf(chars[i]);
                int newIndex = index - shift;
                while (newIndex < 0) {
                    newIndex = alphabetUpperCase.size() + newIndex;
                }
                decryptedWord += alphabetUpperCase.get(newIndex);
            } else {
                decryptedWord += chars[i];
            }
        }
        return decryptedWord;
    }
}
