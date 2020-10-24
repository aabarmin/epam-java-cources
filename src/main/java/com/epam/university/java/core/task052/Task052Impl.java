package com.epam.university.java.core.task052;


public class Task052Impl implements Task052 {
    @Override
    public boolean validateCard(long number) {


        StringBuilder stringBuilder = new StringBuilder(String.valueOf(number));
        if (stringBuilder.length() < 14 || stringBuilder.length() > 19 || number < 0) {
            throw new IllegalArgumentException();
        }
        final int checkNumber = Integer.parseInt(
                String.valueOf(stringBuilder.charAt(stringBuilder.length() - 1))
        );

        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.reverse();
        for (int i = 0; i < stringBuilder.length(); i += 2) {
            int num = Integer.parseInt(String.valueOf(stringBuilder.charAt(i)));
            num *= 2;
            if (Integer.toString(num).length() > 1) {
                int first = Integer.parseInt(String.valueOf(Integer.toString(num).charAt(0)));
                int second = Integer.parseInt(String.valueOf(Integer.toString(num).charAt(1)));
                num = first + second;

            }
            stringBuilder.replace(i, i + 1, String.valueOf(num));
        }
        int sum = 0;

        for (int i = 0; i < stringBuilder.length(); i++) {
            int current = Integer.parseInt(String.valueOf(stringBuilder.charAt(i)));
            sum += current;
        }
        String sumStr = String.valueOf(sum);
        int controlNumber = Integer.parseInt(String.valueOf(sumStr.charAt(sumStr.length() - 1)));

        return 10 - controlNumber == checkNumber;
    }
}
