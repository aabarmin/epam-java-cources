package com.epam.university.java.core.task026;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task026Impl implements Task026 {
    private static List<Character> alphabet = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    private static List<Character> alphabetUpperCase = alphabet
            .stream()
            .map(Character::toUpperCase)
            .collect(Collectors.toList());

    @Override
    public String encrypt(String sourceString, int shift) {

        char[] chars = sourceString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] + "").matches("\\w")) {
                int begIndex = alphabet.contains(chars[i])
                        ? alphabet.indexOf(chars[i]) : alphabetUpperCase.indexOf(chars[i]);
                int nowIndex = begIndex + shift;
                nowIndex = nowIndex >= alphabet.size() ? nowIndex - alphabet.size() : nowIndex;
                chars[i] = alphabet.contains(chars[i])
                        ? alphabet.get(nowIndex) : alphabetUpperCase.get(nowIndex);
            } else {
                continue;
            }
        }
        String result = new String(chars);
        return result;
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        char[] chars = encryptedString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] + "").matches("\\w")) {
                int begIndex = alphabet.contains(chars[i])
                        ? alphabet.indexOf(chars[i]) : alphabetUpperCase.indexOf(chars[i]);
                int nowIndex = begIndex - shift;
                nowIndex = nowIndex < 0 ? alphabet.size() + nowIndex : nowIndex;
                chars[i] = alphabet.contains(chars[i])
                        ? alphabet.get(nowIndex) : alphabetUpperCase.get(nowIndex);
            } else {
                continue;
            }
        }
        String result = new String(chars);
        return result;
    }
}
