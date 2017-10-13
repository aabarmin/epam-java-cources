package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {
    // english alphabet power
    private static final int POWER = 26;
    private final char[] lowerCase;
    private final char[] upperCase;

    {
        lowerCase = new char[POWER];
        upperCase = new char[POWER];

        // filling up arrays of lowercase and uppercase chars of english alphabet
        for (int i = 0; i < POWER; i++) {
            lowerCase[i] = (char) (65 + i);
            upperCase[i] = (char) (97 + i);
        }
    }

    @Override
    public String encrypt(String sourceString, int shift) {
        return cryptographer(true, sourceString, shift);
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        return cryptographer(false, encryptedString, shift);
    }

    /**
     * Encrypting or decrypting source string.
     *
     * @param isEncrypting is source string encrypting or decrypting
     * @param sourceString string to encrypt or decrypt
     * @param shift        shift value
     * @return encrypted or decrypted string
     */
    private String cryptographer(boolean isEncrypting, String sourceString, int shift) {
        StringBuilder result = new StringBuilder();

        // iterating on chars of string
        for (char ch : sourceString.toCharArray()) {
            // initializing char for result string
            char correctChar = ch;
            for (int j = 0; j < POWER; j++) {

                // index of needed char from alphabet
                int index = isEncrypting ? ((j + shift) % POWER) : ((j - shift + POWER) % POWER);

                // replacing char if needed
                if (ch == lowerCase[j]) {
                    correctChar = lowerCase[index];
                }

                // replacing char if needed
                if (ch == upperCase[j]) {
                    correctChar = upperCase[index];
                }
            }

            result.append(correctChar);
        }

        return result.toString();
    }
}
