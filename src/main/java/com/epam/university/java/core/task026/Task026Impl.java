package com.epam.university.java.core.task026;

import java.util.Arrays;

public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        StringBuilder output = new StringBuilder(sourceString.length());
        for (char c: sourceString.toCharArray()) {
            output.append(rotateChar(c, shift));
        }
        return output.toString();
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        StringBuilder output = new StringBuilder(encryptedString.length());
        for (char c: encryptedString.toCharArray()) {
            output.append(rotateChar(c, -shift));
        }
        return output.toString();
    }

    private char rotateChar(char c, int shift) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('a' + (c - 'a' + 26 + shift) % 26);
        }
        if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + (c - 'A' + 26 + shift) % 26);
        }
        return c;
    }
}
