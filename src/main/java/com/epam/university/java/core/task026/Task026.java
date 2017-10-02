package com.epam.university.java.core.task026;

/**
 * Caesar Cipher.
 *
 * <p>
 *     Caesar's cipher rotated every letter in source string by a fixed number K
 *     making it unreadable and encrypted. To decrypt message you need to shift
 *     letters back by a fixed number K.
 *
 *     Non alphabetic symbols like spaces, underlines and other should not
 *     be shifted at all.
 * </p>
 */
public interface Task026 {
    /**
     * Encrypt source string with Caesar Cipher shifting by <code>shift</code> value.
     * @param sourceString source string
     * @param shift shift value
     * @return encrypted string
     */
    String encrypt(String sourceString, int shift);

    /**
     * Decrypt protected string by unshifting it by <code>shift</code> value.
     * @param encryptedString encrypted string
     * @param shift shift value
     * @return decrypted string
     */
    String decrypt(String encryptedString, int shift);
}
