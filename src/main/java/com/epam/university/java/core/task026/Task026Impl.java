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
public class Task026Impl implements Task026 {
    /**
     * Encrypt source string with Caesar Cipher shifting by <code>shift</code> value.
     * @param sourceString source string
     * @param shift shift value
     * @return encrypted string
     */
    @Override
    public String encrypt(String sourceString, int shift) {

        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceString.length(); i++) {
            sb.append(cipher(sourceString.charAt(i), shift));
        }
        return sb.toString();

    }

    /**
     * Encrypt char with Caesar Cipher shifting by <code>shift</code> value.
     * @param c source char
     * @param k shift value
     * @return encrypted string
     */
    public static char cipher(char c, int k) {

        if (k != 0 && Character.isLetter(c)) {

            final int alphaLength = 26;
            final char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
            final int cipherShift = k % alphaLength;

            // shift down to 0..25 for a..z
            char shifted = (char) (c - asciiShift);
            // rotate the letter and handle "wrap-around" for negatives and value >= 26
            shifted = (char) ((shifted + cipherShift + alphaLength) % alphaLength);
            // shift back up to english characters
            return (char) (shifted + asciiShift);

        } else {

            return c;
        }

    }

    /**
     * Decrypt protected string by unshifting it by <code>shift</code> value.
     * @param encryptedString encrypted string
     * @param shift shift value
     * @return decrypted string
     */
    @Override
    public String decrypt(String encryptedString, int shift) {
        return encrypt(encryptedString, -shift);
    }
}
