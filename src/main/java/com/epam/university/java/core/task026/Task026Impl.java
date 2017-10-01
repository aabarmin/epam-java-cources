package com.epam.university.java.core.task026;

/**
 * Created by Александр on 30.09.2017.
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
        return caesarCipher(sourceString, shift);
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
        return caesarCipher(encryptedString, -shift);
    }

    /**
     * Implement a Caesar cipher, both encoding and decoding.
     * So key 2 encrypts "HI" to "JK", but key 28 or -2 encrypts "JK" to "HI".
     *
     * @param source
     * @param offset key is an integer from 1 to 25.
     * @return
     */
    String caesarCipher(String source, int offset) {
        StringBuilder result = new StringBuilder();
        for(char current : source.toCharArray()) {
            if (Character.isLetter(current)) {
                if (Character.isUpperCase(current)) {
                    result.append((char) ('A' + Math.floorMod((current - 'A' + offset), 26)));
                } else {
                    result.append((char) ('a' + Math.floorMod((current - 'a' + offset), 26)));
                }
            } else {
                result.append(current);
            }
        }
        return result.toString();
    }
}
