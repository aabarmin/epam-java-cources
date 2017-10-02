package com.epam.university.java.core.task026;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ilya on 30.09.17.
 */
public class Task026Impl implements Task026 {

    @Override
    public String encrypt(String sourceString, int shift) {
        return calculation(sourceString, (p) -> (p + shift));
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        return calculation(encryptedString, (p) -> (p - shift));
    }

    private String calculation(String string,
        Function<Integer, Integer> function) {
        String[] letters = string.split("");

        return Stream.of(letters)
            .map(l -> {
                if (!l.matches("[^a-zA-Z]")) {
                    Function<String, String> caser = (s) -> s.toLowerCase();
                    if (Character.isUpperCase(l.charAt(0))) {
                        caser = (s) -> s.toUpperCase();
                    }
                    String letter = Alfabet.values()[
                        (function.apply(Alfabet.valueOf(l.toLowerCase()).ordinal())
                            + Alfabet.values().length) % Alfabet.values().length].toString();
                    letter = caser.apply(letter);
                    return letter;
                } else {
                    return l;
                }
            }).collect(Collectors.joining());
    }
}
