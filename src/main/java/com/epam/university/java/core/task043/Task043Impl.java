package com.epam.university.java.core.task043;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task043Impl implements Task043 {
    public static final Map<String, Character> MORSE_DECODE = new HashMap<>() {
        {
            put(".-", 'A');
            put("-...", 'B');
            put("-.-.", 'C');
            put("-..", 'D');
            put(".", 'E');
            put("..-.", 'F');
            put("--.", 'G');
            put("....", 'H');
            put("..", 'I');
            put(".---", 'J');
            put("-.-", 'K');
            put(".-..", 'L');
            put("--", 'M');
            put("-.", 'N');
            put("---", 'O');
            put(".--.", 'P');
            put("--.-", 'Q');
            put(".-.", 'R');
            put("...", 'S');
            put("-", 'T');
            put("..-", 'U');
            put("...-", 'V');
            put(".--", 'W');
            put("-..-", 'X');
            put("-.--", 'Y');
            put("--..", 'Z');
            put("--..--", ',');
        }
    };

    @Override
    public String encode(String sourceString) {
        validate(sourceString);
        StringBuilder encodingString = new StringBuilder();
        char[] chars = sourceString.toCharArray();
        for (char letter :
                chars) {
            if (MORSE_DECODE.containsValue(letter)) {
                encodingString.append(getKeyByValue(MORSE_DECODE, letter)).append(" ");
            } else {
                encodingString.append("  ");
            }
        }
        return encodingString.toString().trim();
    }

    @Override
    public String decode(String sourceString) {
        validate(sourceString);
        StringBuilder decodingString = new StringBuilder();
        String[] words = sourceString.split("\\s{3}");
        for (String word :
                words) {
            String[] morzeChar = word.trim().split("\\s+");
            for (String str :
                    morzeChar) {
                if (MORSE_DECODE.containsKey(str)) {
                    decodingString.append(MORSE_DECODE.get(str));
                }
            }
            decodingString.append(" ");
        }

        return decodingString.toString().trim();
    }

    private void validate(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Getting key by value in the map.
     * @param map map to find the key
     * @param value value for searching
     * @return key in the map.
     */
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
