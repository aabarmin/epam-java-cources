package com.epam.university.java.core.task026;

import java.util.ArrayList;


public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        ArrayList<String> letters = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            String s = String.valueOf(c);
            letters.add(s);
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < sourceString.length(); i++) {
            String symbol = sourceString.substring(i, i + 1);
            for (int j = 0; j < letters.size(); j++) {
                if (symbol.compareToIgnoreCase(letters.get(j)) == 0) {
                    int check = symbol.compareTo(letters.get(j));
                    int k = j + shift;
                    if (k >= letters.size()) {
                        k = k - letters.size();
                    }
                    if (check < 0) {
                        result.append(letters.get(k).toUpperCase());
                        break;
                    }
                    if (check == 0) {
                        result.append(letters.get(k));
                        break;
                    }
                } else if (symbol.matches("[\\s,.:!?]")) {
                    result.append(symbol);
                    break;
                }
            }
        }

        return result.toString();
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        ArrayList<String> letters = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            String s = String.valueOf(c);
            letters.add(s);
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < encryptedString.length(); i++) {
            String symbol = encryptedString.substring(i, i + 1);
            for (int j = 0; j < letters.size(); j++) {
                if (symbol.compareToIgnoreCase(letters.get(j)) == 0) {
                    int check = symbol.compareTo(letters.get(j));
                    int k = j - shift;
                    if (k < 0) {
                        k = letters.size() + k;
                    }
                    if (check < 0) {
                        result.append(letters.get(k).toUpperCase());
                        break;
                    }
                    if (check == 0) {
                        result.append(letters.get(k));
                        break;
                    }
                } else if (symbol.matches("[\\s,.:!?]")) {
                    result.append(symbol);
                    break;
                }
            }
        }

        return result.toString();
    }
}
