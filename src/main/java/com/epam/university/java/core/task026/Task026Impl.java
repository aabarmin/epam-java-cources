package com.epam.university.java.core.task026;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task026Impl implements Task026 {
    int startCapitalLetter = 65;
    int endCapitalLetter = 90;
    int startSmallLetter = 97;
    int endSmallLetter = 122;

    @Override
    public String encrypt(String sourceString, int shift) {
        char[] myChar = sourceString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : myChar
        ) {

            if (Character.isLetter(c) && Character.isUpperCase(c)) {

                int temp = c;
                if (temp + shift > endCapitalLetter) {
                    int temp2 = shift - (endCapitalLetter - temp) - 1;
                    temp = startCapitalLetter + temp2;
                    sb.append((char) temp);
                } else {
                    temp += shift;
                    sb.append((char) temp);
                }

            } else if (Character.isLetter(c) && Character.isLowerCase(c)) {

                int temp = c;
                if (temp + shift > endSmallLetter) {
                    int temp2 = shift - (endSmallLetter - temp) - 1;
                    temp = startSmallLetter + temp2;
                    sb.append((char) temp);
                } else {
                    temp += shift;
                    sb.append((char) temp);
                }

            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        char[] myChar = encryptedString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : myChar
        ) {

            if (Character.isLetter(c) && Character.isUpperCase(c)) {

                int temp = c;
                if (temp - shift < startCapitalLetter) {
                    int temp2 = endCapitalLetter - (shift - (temp - startCapitalLetter) - 1);
                    sb.append((char) temp2);
                } else {
                    temp -= shift;
                    sb.append((char) temp);
                }

            } else if (Character.isLetter(c) && Character.isLowerCase(c)) {

                int temp = c;
                if (temp - shift < startSmallLetter) {
                    int temp2 = endSmallLetter - (shift - (temp - startSmallLetter) - 1);
                    sb.append((char) temp2);
                } else {
                    temp -= shift;
                    sb.append((char) temp);
                }

            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
