package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null || sourceString.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (shift == 0) {
            return sourceString;
        }
        int startL = 97;
        int startU = 65;
        int endL = 122;
        int endU = 90;
        char[] arrChar = sourceString.toCharArray();
        for (int i = 0; i < arrChar.length; i++) {
            if (Character.isLetter(arrChar[i])) {
                int buf = arrChar[i];
                int iBuf = buf + shift;
                if (Character.isUpperCase(arrChar[i])) {
                    if (iBuf > endU) {
                        buf = iBuf - endU;
                        buf = buf + startU - 1;
                        char chBuf = (char) (buf);
                        arrChar[i] = chBuf;
                    } else {
                        char chBuf = (char) (iBuf);
                        arrChar[i] = chBuf;
                    }
                } else {
                    if (iBuf > endL) {
                        buf = iBuf - endL;
                        buf = buf + startL - 1;
                        char chBuf = (char) (buf);
                        arrChar[i] = chBuf;
                    } else {
                        char chBuf = (char) (iBuf);
                        arrChar[i] = chBuf;
                    }
                }
            }
        }
        return String.valueOf(arrChar);
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        if (encryptedString == null || encryptedString.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (shift == 0) {
            return encryptedString;
        }
        int startL = 97;
        int startU = 65;
        int endL = 122;
        int endU = 90;
        char[] arrChar = encryptedString.toCharArray();
        for (int i = 0; i < arrChar.length; i++) {
            if (Character.isLetter(arrChar[i])) {
                int buf = arrChar[i];
                int iBuf = buf - shift;
                if (Character.isUpperCase(arrChar[i])) {
                    if (iBuf < startU) {
                        buf = startU - iBuf;
                        buf = endU - buf + 1;
                        char chBuf = (char) (buf);
                        arrChar[i] = chBuf;
                    } else {
                        char chBuf = (char) (iBuf);
                        arrChar[i] = chBuf;
                    }
                } else {
                    if (iBuf < startL) {
                        buf = startL - iBuf;
                        buf = endL - buf + 1;
                        char chBuf = (char) (buf);
                        arrChar[i] = chBuf;
                    } else {
                        char chBuf = (char) (iBuf);
                        arrChar[i] = chBuf;
                    }
                }
            }
        }
        return String.valueOf(arrChar);
    }
}
