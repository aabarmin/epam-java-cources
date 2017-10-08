package com.epam.university.java.core.task026;

import java.nio.charset.Charset;

public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        byte[] inter = new byte[sourceString.length()];
        for (int i = 0; i < sourceString.length(); i++) {

            int codePoint = sourceString.codePointAt(i);

            int codePointShifted = codePoint + shift;

            boolean isSmallLetter = Character.isLowerCase(codePoint);

            boolean isUpperLetter = Character.isUpperCase(codePoint);

            if (isSmallLetter) {
                if (!Character.isLowerCase(codePointShifted)) {
                    inter[i] = (byte) (codePointShifted - 122 + 96);
                } else {
                    inter[i] = (byte) codePointShifted;
                }
            } else if(isUpperLetter) {
                if (!Character.isUpperCase(codePointShifted)) {
                    inter[i] = (byte) (codePointShifted - 90 + 64);
                } else {
                    inter[i] = (byte) codePointShifted;
                }
            } else {
                inter[i] = (byte) codePoint;
            }
        }
        return new String(inter, Charset.defaultCharset());
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        byte[] inter = new byte[encryptedString.length()];
        for (int i = 0; i < encryptedString.length(); i++) {

            int codePoint = encryptedString.codePointAt(i);

            int codePointShifted = codePoint - shift;

            boolean isSmallLetter = Character.isLowerCase(codePoint);

            boolean isUpperLetter = Character.isUpperCase(codePoint);

            if (isSmallLetter) {
                if (!Character.isLowerCase(codePointShifted)) {
                    inter[i] = (byte) (122 - (96 - codePointShifted));
                } else {
                    inter[i] = (byte) codePointShifted;
                }
            } else if(isUpperLetter) {
                if (!Character.isUpperCase(codePointShifted)) {
                    inter[i] = (byte) (90 - (64 - codePointShifted));
                } else {
                    inter[i] = (byte) codePointShifted;
                }
            } else {
                inter[i] = (byte) codePoint;
            }
        }
        return new String(inter, Charset.defaultCharset());
    }
}
