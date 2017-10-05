package com.epam.university.java.core.task026;

/**
 * Created by Вера on 04.10.2017.
 */
public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        char[] chars = sourceString.toCharArray();
        String result = "";
        int j = 0;

        for (int i = 0; i < chars.length; i++) {
            // если заглавная буква
            if (64 < chars[i] && chars[i] < 91) {
                j = ((int)chars[i] + shift);
                if (j > 90) {
                    j = j - 26;
                }
                chars[i] = (char) j;
            }

            // если строчная буква
            if (96 < chars[i] && chars[i] < 122) {
                j = ((int)chars[i] + shift);
                if (j > 121) {
                    j = j - 26;
                }
                chars[i] = (char) j;

            }

            result += chars[i];
        }

        //System.out.println(result);
        return result;
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        char[] chars = encryptedString.toCharArray();
        String result = "";
        int j = 0;

        for (int i = 0; i < chars.length; i++) {
            // если заглавная буква
            if (64 < chars[i] && chars[i] < 91) {
                j = ((int)chars[i] - shift);
                if (j < 63) {
                    j = j + 26;
                }
                chars[i] = (char) j;
            }

            // если строчная буква
            if (96 < chars[i] && chars[i] < 122) {
                j = ((int)chars[i] - shift);
                if (j < 95) {
                    j = j + 26;
                }
                chars[i] = (char) j;

            }

            result += chars[i];
        }

        //System.out.println(result);
        return result;
    }
}
