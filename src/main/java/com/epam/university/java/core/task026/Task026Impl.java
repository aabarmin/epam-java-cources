package com.epam.university.java.core.task026;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ilya on 30.09.17.
 */
public class Task026Impl implements Task026 {

    private final static Map<Integer, String> INT_TO_STRING = new HashMap();
    private final static int ALFABET_LENGTH = 26;
    private final static Map<String, Integer> STRING_TO_INT = new HashMap();

    static {
        INT_TO_STRING.put(0, "a");
        INT_TO_STRING.put(1, "b");
        INT_TO_STRING.put(2, "c");
        INT_TO_STRING.put(3, "d");
        INT_TO_STRING.put(4, "e");
        INT_TO_STRING.put(5, "f");
        INT_TO_STRING.put(6, "g");
        INT_TO_STRING.put(7, "h");
        INT_TO_STRING.put(8, "i");
        INT_TO_STRING.put(9, "j");
        INT_TO_STRING.put(10, "k");
        INT_TO_STRING.put(11, "l");
        INT_TO_STRING.put(12, "m");
        INT_TO_STRING.put(13, "n");
        INT_TO_STRING.put(14, "o");
        INT_TO_STRING.put(15, "p");
        INT_TO_STRING.put(16, "q");
        INT_TO_STRING.put(17, "r");
        INT_TO_STRING.put(18, "s");
        INT_TO_STRING.put(19, "t");
        INT_TO_STRING.put(20, "u");
        INT_TO_STRING.put(21, "v");
        INT_TO_STRING.put(22, "w");
        INT_TO_STRING.put(23, "x");
        INT_TO_STRING.put(24, "y");
        INT_TO_STRING.put(25, "z");
    }

    static {
        STRING_TO_INT.put("a", 0);
        STRING_TO_INT.put("b", 1);
        STRING_TO_INT.put("c", 2);
        STRING_TO_INT.put("d", 3);
        STRING_TO_INT.put("e", 4);
        STRING_TO_INT.put("f", 5);
        STRING_TO_INT.put("g", 6);
        STRING_TO_INT.put("h", 7);
        STRING_TO_INT.put("i", 8);
        STRING_TO_INT.put("j", 9);
        STRING_TO_INT.put("k", 10);
        STRING_TO_INT.put("l", 11);
        STRING_TO_INT.put("m", 12);
        STRING_TO_INT.put("n", 13);
        STRING_TO_INT.put("o", 14);
        STRING_TO_INT.put("p", 15);
        STRING_TO_INT.put("q", 16);
        STRING_TO_INT.put("r", 17);
        STRING_TO_INT.put("s", 18);
        STRING_TO_INT.put("t", 19);
        STRING_TO_INT.put("u", 20);
        STRING_TO_INT.put("v", 21);
        STRING_TO_INT.put("w", 22);
        STRING_TO_INT.put("x", 23);
        STRING_TO_INT.put("y", 24);
        STRING_TO_INT.put("z", 25);
    }


    @Override
    public String encrypt(String sourceString, int shift) {
        return calculation(sourceString, shift, (p, i) -> (p + i));
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        return calculation(encryptedString, shift, (p, i) -> (p - i));
    }

    private String calculation(String string, int shift,
        BiFunction<Integer, Integer, Integer> function) {
        String[] letters = string.split("");

        return Stream.of(letters)
            .map(l -> {
                if (!l.matches("[^a-zA-Z]")) {
                    Function<String, String> caser = (s) -> s.toLowerCase();
                    if (Character.isUpperCase(l.charAt(0))) {
                        caser = (s) -> s.toUpperCase();
                    }
                    String letter = INT_TO_STRING
                        .get((function.apply(STRING_TO_INT.get(l.toLowerCase()), shift)
                            + ALFABET_LENGTH) % ALFABET_LENGTH);
                    letter = caser.apply(letter);
                    return letter;
                } else {
                    return l;
                }
            }).collect(Collectors.joining());
    }
}
