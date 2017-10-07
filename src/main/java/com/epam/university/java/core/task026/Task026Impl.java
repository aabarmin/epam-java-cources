package com.epam.university.java.core.task026;

/**
 * Caesar Cipher.
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
        return sourceString.chars()
            .map(cp -> this.shift(cp, shift))
            .collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
            ).toString();
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

    /**
     * Shift a character through the English alphabet if it is an alphabetic.
     * @param codePoint code point of the character
     * @param shiftDist distance of the shift
     * @return shifted character
     */
    private int shift(final int codePoint, int shiftDist) {
        if (!Character.isAlphabetic(codePoint)) {
            return codePoint;
        }
        final int alphaLen = 'z' - 'a' + 1;
        final char alphaStart = Character.isUpperCase(codePoint) ? 'A' : 'a';
        shiftDist %= alphaLen;
        return ((codePoint - alphaStart) + shiftDist + alphaLen) % alphaLen + alphaStart;
    }

}
