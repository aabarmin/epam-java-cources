package com.epam.university.java.core.dmitry_novikov_task2;


/**
 * Author Dmitry Novikov 20-Sep-20.
 */
public class Task2Impl implements Task2 {

    @Override
    public String getResultList(String first, String second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        if (first.isEmpty() || second.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String result = "";
        for (int length = first.length(); length > 0; length--) {
            int startIndex = 0;
            while (startIndex + length <= first.length()) {
                String current = first.substring(startIndex, startIndex + length);
                if (second.contains(current)) {
                    result = current;
                    break;
                }
                startIndex++;
            }
            if (result.length() != 0) {
                break;
            }
        }
        return result;
    }
}
