package com.epam.university.java.core.task026;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task026Impl implements Task026 {

    @Override
    public String encrypt(String sourceString, int shift) {
        Function<String, String> function = (n) -> {
            char ch = n.charAt(0);
            if (!Character.isAlphabetic(ch)) {
                return n;
            }
            char start = 'a';
            if (Character.isUpperCase(ch)) {
                start = 'A';
            }
            char length = 'z' - 'a' + 1;
            ch += shift % length - start + length;
            ch %= length;
            ch += start;
            String result = Character.toString(ch);
            return result;
        };
        String result = Arrays.stream(sourceString.split(""))
                .map(function)
                .collect(Collectors.joining());
        return result;

    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        return encrypt(encryptedString, shift * (-1));
    }
}