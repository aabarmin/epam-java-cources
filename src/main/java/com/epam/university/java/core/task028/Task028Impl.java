package com.epam.university.java.core.task028;


public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {

        int amountOfWays = 0;

        int max = (int) Math.pow(value, 1.0 / power);


        if (max == 1) {
            return 0;
        }

        int[] powers = new int[max];

//        for (int i = 0; i < powers.length; i++) {
//            powers[i] = 0;
//        }

        int breakValue = (int) Math.pow(max, 2) - 1;

        for (int i = 0; i < breakValue; i++) {
            int sum = 0;
            int index = 0;

            String binaryNum = Integer.toBinaryString(i);
            if (binaryNum.length() < max) {
                for (int j = binaryNum.length(); j < max; j++) {
                    binaryNum = "0" + binaryNum;
                }
            }
            char[] chars = binaryNum.toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                powers[index] = Integer.parseInt(String.valueOf(chars[j]));
                index++;
            }

            for (int j = 0; j < powers.length; j++) {
                if (powers[j] != 0) {
                    sum += Math.pow(j + 1, power);      // мб косяк на  1
                }
                if (sum == value) {
                    amountOfWays++;
                }
                if (sum > value) {
                    break;
                }
            }
        }

        return amountOfWays;
    }
}
