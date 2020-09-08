package com.epam.university.java.core.task026;

/**
 * Created by Romin Nuro on 08.09.2020 15:16.
 */
public class Task026Impl implements Task026 {
    /**
     * Encrypt source string with Caesar Cipher shifting by <code>shift</code> value.
     *
     * @param sourceString source string
     * @param shift        shift value
     * @return encrypted string
     */
    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        char[] chars = sourceString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i])) {
                continue;
            }
            int offset;
            if (Character.isUpperCase(chars[i])) {
                offset = 65;
            } else {
                offset = 97;
            }
            chars[i] = (char) ((chars[i] + shift - offset) % 26 + offset);
        }
        return String.valueOf(chars);
    }

    /**
     * Decrypt protected string by unshifting it by <code>shift</code> value.
     *
     * @param encryptedString encrypted string
     * @param shift           shift value
     * @return decrypted string
     */
    @Override
    public String decrypt(String encryptedString, int shift) {
        char[] chars = encryptedString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i])) {
                continue;
            }
            int offset;
            if (Character.isUpperCase(chars[i])) {
                offset = 65;
            } else {
                offset = 97;
            }
            int newPos = chars[i] - shift - offset;
            if (newPos >= 0) {
                chars[i] = (char) (newPos % 26 + offset);
            } else {
                chars[i] = (char) (newPos + offset + 26);
            }
        }
        return String.valueOf(chars);
    }
}
