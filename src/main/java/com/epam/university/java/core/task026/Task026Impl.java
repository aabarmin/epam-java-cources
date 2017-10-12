package com.epam.university.java.core.task026;

import com.epam.university.java.core.utils.common.Validator;

/**
 * Class implements Task026.
 */
public class Task026Impl implements Task026 {
    private String alphabetString;
    private String[] alphabet;
    private String[] alphabetAllCaps;

    /**
     * Initialization of the class object.
     */
    public Task026Impl() {
        alphabetString = "abcdefghijklmnopqrstuvwxyz";
        alphabet = alphabetString.split("(?!^)");
        alphabetAllCaps = alphabetString.toUpperCase().split("(?!^)");
    }

    /**
     * Get index of letter after shifting.
     *
     * @param alphabet the alphabet
     * @param toFind   the letter to find
     * @param shift    the shift number for the current letter's position
     * @return index after shifting
     * @throws IllegalArgumentException if at least one of
     *                                  <code>String</code> parameters is null
     */
    private int getIndex(String alphabet, String toFind, int shift) {
        Validator.validateNotNull(alphabet, toFind,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);

        int index = (alphabet.indexOf(toFind) + shift) % alphabet
                .length();
        if (index < 0) {
            do {
                index = alphabet.length() + index;
            } while (index < 0);
        }
        return index;
    }

    /**
     * Encrypt the letter with new shifted one.
     *
     * @param regex          regex to check the symbol is the letter of needed case
     * @param letter         the letter to encrypt
     * @param shift          the shift number for the current letter's position
     * @param alphabet       the alphabet to use in array
     * @param alphabetString the alphabet to
     *                       use in string
     * @return <code>String</code> encrypted letter
     */
    private String encryptLetter(String regex, String letter, int
            shift, String[] alphabet, String alphabetString) {
        Validator.validateNotNull(regex, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateNotNull(letter, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateNotNull(alphabet,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateNotNull(alphabetString, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        return letter.replaceAll(regex, alphabet[getIndex(
                alphabetString, letter, shift)]);
    }

    @Override
    public String encrypt(String sourceString, int shift) {
        Validator.validateNotNull(sourceString,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);

        String[] sourceStringArray = sourceString.split("(?!^)");
        for (int i = 0; i < sourceString.length(); i++) {
            sourceStringArray[i] = encryptLetter("[a-z]",
                    sourceStringArray[i], shift, alphabet, alphabetString);
            sourceStringArray[i] = encryptLetter("[A-Z]",
                    sourceStringArray[i], shift, alphabetAllCaps, alphabetString
                            .toUpperCase());
        }
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < sourceStringArray.length; i++) {
            resultString.append(sourceStringArray[i]);
        }
        return resultString.toString();
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        return encrypt(encryptedString, -shift);
    }
}
