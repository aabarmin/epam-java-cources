package com.epam.university.java.core.task026;

import com.epam.university.java.core.Validator;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        new Validator().vaildate(sourceString);
        byte[] bytes = sourceString.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (Character.isLetter(bytes[i])) {
                bytes[i] = rotateLetterRight(bytes[i], shift);
            }
        }
        return new String(bytes);
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        new Validator().vaildate(encryptedString);
        byte[] bytes = encryptedString.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (Character.isLetter(bytes[i])) {
                bytes[i] = rotateLetterLeft(bytes[i], shift);
            }
        }
        return new String(bytes);
    }

    private byte rotateLetterRight(byte b, int shift) {
        return rotateLetterBiderectional(b, shift);
    }

    private byte rotateLetterLeft(byte b, int shift) {
        return rotateLetterBiderectional(b, -shift);
    }

    private byte rotateLetterBiderectional(byte b, int shift) {
        byte result;
        int startLetter;
        int stopLetter;
        if (Character.isUpperCase(b)) {
            startLetter = 65;
            stopLetter = 91;
        } else {
            startLetter = 97;
            stopLetter = 123;
        }
        int oldLetterPos = b - startLetter;
        int newLetterPos = (oldLetterPos + shift) % 26;
        result = (byte) (newLetterPos >= 0
                ? (startLetter + newLetterPos)
                : (stopLetter + newLetterPos));
        return result;
    }
}
