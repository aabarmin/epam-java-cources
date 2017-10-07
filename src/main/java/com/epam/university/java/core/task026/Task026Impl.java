package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        byte[] bytes = sourceString.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (Character.isLetter(bytes[i])) {
                bytes[i] = rotateLetter(bytes[i], shift);
            }
        }
        return new String(bytes);
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        if (encryptedString == null) {
            throw new IllegalArgumentException();
        }
        byte[] bytes = encryptedString.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (Character.isLetter(bytes[i])) {
                bytes[i] = rotateLetter(bytes[i], -shift);
            }
        }
        return new String(bytes);
    }


    private byte rotateLetter(byte b, int shift) {
        byte result;
        int startLetter;
        int stopLetter;
        if (Character.isUpperCase(b)) {
            startLetter = (int) 'A';
            stopLetter = ((int) 'Z')+1;
        } else {
            startLetter = (int) 'a';
            stopLetter = ((int) 'z')+1;
        }
        int oldLetterPos = b - startLetter;
        int newLetterPos = (oldLetterPos + shift) % 26;
        result = (byte) (newLetterPos >= 0
                ? (startLetter + newLetterPos)
                : (stopLetter + newLetterPos));
        return result;
    }
}
