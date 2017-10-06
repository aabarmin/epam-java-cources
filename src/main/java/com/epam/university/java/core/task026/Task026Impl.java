package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {
    private static final int FIRST_CAPITAL_LETTER = 65;
    private static final int LAST_CAPITAL_LETTER = 90;
    private static final int FIRST_SMALL_LETTER = 97;
    private static final int LAST_SMALL_LETTER = 122;
    private static final int NUMBER_LETTERS = 26;

    @Override
    public String encrypt(String sourceString, int shift) {
        char[] letters = sourceString.toCharArray();
        shift = parametersCheck(sourceString, shift);
        for (int i = 0; i < letters.length; i++) {
            int newLetter = letters[i] + shift;
            if (String.valueOf(letters[i]).matches("[a-z]")) {
                if (newLetter > LAST_SMALL_LETTER) {
                    newLetter -= LAST_SMALL_LETTER;
                    letters[i] = (char) (FIRST_SMALL_LETTER + newLetter - 1);
                } else {
                    letters[i] = (char) newLetter;
                }
            } else if (String.valueOf(letters[i]).matches("[A-Z]")) {
                if (newLetter > LAST_CAPITAL_LETTER) {
                    newLetter -= LAST_CAPITAL_LETTER;
                    letters[i] = (char) (FIRST_CAPITAL_LETTER + newLetter - 1);
                } else {
                    letters[i] = (char) newLetter;
                }
            }
        }
        return new String(letters);
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        char[] letters = encryptedString.toCharArray();
        shift = parametersCheck(encryptedString, shift);
        for (int i = 0; i < letters.length; i++) {
            int newLetter = letters[i] - shift;
            if (String.valueOf(letters[i]).matches("[a-z]")) {
                if (newLetter < FIRST_SMALL_LETTER) {
                    newLetter = FIRST_SMALL_LETTER - newLetter;
                    letters[i] = (char) (LAST_SMALL_LETTER - newLetter + 1);
                } else {
                    letters[i] = (char) newLetter;
                }
            } else if (String.valueOf(letters[i]).matches("[A-Z]")) {
                if (newLetter < FIRST_CAPITAL_LETTER) {
                    newLetter = FIRST_CAPITAL_LETTER - newLetter;
                    letters[i] = (char) (LAST_CAPITAL_LETTER - newLetter + 1);
                } else {
                    letters[i] = (char) newLetter;
                }
            }
        }
        return new String(letters);
    }

    private int parametersCheck(String string, int shift) {
        if (string == null) {
            throw new IllegalArgumentException("String wasn't provided!");
        }
        if (shift > NUMBER_LETTERS) {
            shift %= NUMBER_LETTERS;
        }
        return shift;
    }
}