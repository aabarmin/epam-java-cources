package com.epam.university.java.core.task026;

/**
 * {@inheritDoc}
 */
public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        char[] chars = sourceString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char active = chars[i];
            if (active >= 'A' && active <= 'Z') {
                if (active + shift > 'Z') {
                    int position = active + shift - 'Z';
                    chars[i] = (char) ('A' + position - 1);
                } else {
                    chars[i] = (char) (active + shift);
                }
            } else if (active >= 'a' && active <= 'z') {
                if (active + shift > 'z') {
                    int position = active + shift - 'z';
                    chars[i] = (char) ('a' + position - 1);
                } else {
                    chars[i] = (char) (active + shift);
                }
            }
        }

        return new String(chars);
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        char[] chars = encryptedString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char active = chars[i];
            if (active >= 'A' && active <= 'Z') {
                if (active - shift < 'A') {
                    int position = 'A' - (active - shift);
                    chars[i] = (char) ('Z' - position + 1);
                } else {
                    chars[i] = (char) (active - shift);
                }
            } else if (active >= 'a' && active <= 'z') {
                if (active - shift < 'a') {
                    int position = 'a' - (active - shift);
                    chars[i] = (char) ('z' - position + 1);
                } else {
                    chars[i] = (char) (active - shift);
                }
            }
        }

        return new String(chars);
    }
}
