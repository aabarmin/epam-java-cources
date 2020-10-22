package com.epam.university.java.core.task043;

import java.util.HashMap;
import java.util.Map;

public class Task043Impl implements Task043 {


    private static final HashMap<Character, String> morseAlphabet = new HashMap<>();
    private static final HashMap<String, Character> morseDecodeAlphabet = new HashMap<>();

    static {
        morseDecodeAlphabet.put(".-", 'A');
        morseDecodeAlphabet.put("-...", 'B');
        morseDecodeAlphabet.put("-.-.", 'C');
        morseDecodeAlphabet.put("-..", 'D');
        morseDecodeAlphabet.put(".", 'E');
        morseDecodeAlphabet.put("..-.", 'F');
        morseDecodeAlphabet.put("--.", 'G');
        morseDecodeAlphabet.put("....", 'H');
        morseDecodeAlphabet.put("..", 'I');
        morseDecodeAlphabet.put(".---", 'J');
        morseDecodeAlphabet.put("-.-", 'K');
        morseDecodeAlphabet.put(".-..", 'L');
        morseDecodeAlphabet.put("--", 'M');
        morseDecodeAlphabet.put("-.", 'N');
        morseDecodeAlphabet.put("---", 'O');
        morseDecodeAlphabet.put(".--.", 'P');
        morseDecodeAlphabet.put("--.-", 'Q');
        morseDecodeAlphabet.put(".-.", 'R');
        morseDecodeAlphabet.put("...", 'S');
        morseDecodeAlphabet.put("-", 'T');
        morseDecodeAlphabet.put("..-", 'U');
        morseDecodeAlphabet.put("...-", 'V');
        morseDecodeAlphabet.put(".--", 'W');
        morseDecodeAlphabet.put("-..-", 'X');
        morseDecodeAlphabet.put("-.--", 'Y');
        morseDecodeAlphabet.put("--..", 'Z');
        morseDecodeAlphabet.put("--..--", ',');
    }

    static {
        morseAlphabet.put('A', ".-");
        morseAlphabet.put('B', "-...");
        morseAlphabet.put('C', "-.-.");
        morseAlphabet.put('D', "-..");
        morseAlphabet.put('E', ".");
        morseAlphabet.put('F', "..-.");
        morseAlphabet.put('G', "--.");
        morseAlphabet.put('H', "....");
        morseAlphabet.put('I', "..");
        morseAlphabet.put('J', ".---");
        morseAlphabet.put('K', "-.-");
        morseAlphabet.put('L', ".-..");
        morseAlphabet.put('M', "--");
        morseAlphabet.put('N', "-.");
        morseAlphabet.put('O', "---");
        morseAlphabet.put('P', ".--.");
        morseAlphabet.put('Q', "--.-");
        morseAlphabet.put('R', ".-.");
        morseAlphabet.put('S', "...");
        morseAlphabet.put('T', "-");
        morseAlphabet.put('U', "..-");
        morseAlphabet.put('V', "...-");
        morseAlphabet.put('W', ".--");
        morseAlphabet.put('X', "-..-");
        morseAlphabet.put('Y', "-.--");
        morseAlphabet.put('Z', "--..");
        morseAlphabet.put(',', "--..--");
    }

    @Override
    public String encode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder morseString = new StringBuilder();
        char[] chars = sourceString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (morseAlphabet.containsKey(chars[i])) {
                String morseChar = morseAlphabet.get(chars[i]);
                morseString.append(morseChar);
                if (i != chars.length - 1) {
                    morseString.append(" ");
                }
            } else if (chars[i] == ' ') {
                morseString.append("  ");
            }
        }
        return morseString.toString();
    }

    @Override
    public String decode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder morseString = new StringBuilder();
        String[] morseWords = sourceString.split("   ");
        for (int i = 0; i < morseWords.length; i++) {
            char[] letters = morseWords[i].toCharArray();
            String word = wordFromMorse(letters);
            morseString.append(word);
            if (i != morseWords.length - 1) {
                morseString.append(" ");
            }
        }

        return morseString.toString();
    }

    private String wordFromMorse(char[] letters) {
        StringBuilder word = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            letter.append(letters[i]);
            if (letters[i] == ' ') {
                letter.delete(letter.length() - 1, letter.length());
                word.append(morseDecodeAlphabet.get(letter.toString()));
                letter.delete(0, letter.length());
            }
            if (i == letters.length - 1) {
                word.append(morseDecodeAlphabet.get(letter.toString()));
                letter.delete(0, letter.length());
            }
        }
        return word.toString();
    }
}