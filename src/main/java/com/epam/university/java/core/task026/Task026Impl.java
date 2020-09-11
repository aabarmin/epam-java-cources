package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {

        if (sourceString.isEmpty() || shift > 26) {
            throw new IllegalArgumentException();
        }

        byte[] symbols = sourceString.getBytes();

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] > 64 && symbols[i] < 91) {
                if (symbols[i] + shift > 90) {
                    symbols[i] = (byte) ((symbols[i] + shift) - 26);
                } else {
                    symbols[i] = (byte) (symbols[i] + shift);
                }
            }
            if (symbols[i] > 96 && symbols[i] < 123) {
                if (symbols[i] + shift > 122) {
                    symbols[i] = (byte) ((symbols[i] + shift) - 26);
                } else {
                    symbols[i] = (byte) (symbols[i] + shift);
                }
            }

        }

        return new String(symbols);
    }

    @Override
    public String decrypt(String encryptedString, int shift) {


        if (encryptedString.length() == 0 || shift > 26) {
            throw new IllegalArgumentException();
        }

        byte[] symbols = encryptedString.getBytes();

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] > 64 && symbols[i] < 91) {
                if (symbols[i] - shift < 65) {
                    symbols[i] = (byte) ((symbols[i] - shift) + 26);
                } else {
                    symbols[i] = (byte) (symbols[i] - shift);
                }
            }
            if (symbols[i] > 96 && symbols[i] < 123) {
                if (symbols[i] - shift < 97) {
                    symbols[i] = (byte) ((symbols[i] - shift) + 26);
                } else {
                    symbols[i] = (byte) (symbols[i] - shift);
                }
            }

        }


        return new String(symbols);
    }
}
