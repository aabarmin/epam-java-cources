package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {

    @Override
    public String encrypt(String sourceString, int shift) {
        char[] array = sourceString.toCharArray();
        StringBuilder sb = new StringBuilder("");
        if (shift > 26) {
            shift = shift % 26;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' || array[i] == ',') {
                sb.append(array[i]);
            } else {
                if (array[i] >= 97 && array[i] <= 122) {
                    if (array[i] + shift > 122) {
                        sb.append((char) (96 + (array[i] + shift - 122)));
                    } else {
                        sb.append((char) (array[i] + shift));
                    }
                } else if (array[i] >= 65 && array[i] <= 90) {
                    if (array[i] + shift > 90) {
                        sb.append((char) (64 + (array[i] + shift - 90)));
                    } else {
                        sb.append((char) (array[i] + shift));
                    }
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        char[] array = encryptedString.toCharArray();
        StringBuilder sb = new StringBuilder("");
        if (shift > 26) {
            shift = shift % 26;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' || array[i] == ',') {
                sb.append(array[i]);
            } else {
                if (array[i] >= 97 && array[i] <= 122) {
                    if (array[i] - shift < 97) {
                        sb.append((char) (123 + (array[i] - shift - 97)));
                    } else {
                        sb.append((char) (array[i] - shift));
                    }
                } else if (array[i] >= 65 && array[i] <= 90) {
                    if (array[i] - shift < 65) {
                        sb.append((char) (91 + (array[i] - shift - 65)));
                    } else {
                        sb.append((char) (array[i] - shift));
                    }
                }
            }
        }
        return sb.toString();
    }
}
