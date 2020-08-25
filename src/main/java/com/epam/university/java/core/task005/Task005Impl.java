package com.epam.university.java.core.task005;

/**
 * Created by Romin Nuro on 25.08.2020 15:26.
 */
public class Task005Impl implements Task005 {
    /**
     * Find two numbers, quotient of which will be closest to PI number. Ex. if digit is 1,
     * holder values should be between 1 and 9, if digits is equals to 2, values should
     * be between 10 and 99 and so on.
     * <p>
     * Tip: Math.abs((a / b) - Math.PI) -> min
     * </p>
     *
     * @param digits amount of digits in numbers.
     * @return holder which contains both numbers
     * @throws IllegalArgumentException if digits less or equals to the zero, or more than ten
     */
    @Override
    public PiHolder findPi(int digits) {
        if (digits < 1 || digits > 10) {
            throw new IllegalArgumentException();
        }
        int numerator = 1;
        int denominator = 1;
        double delta = 2.0;
        for (int i = (int) Math.pow(10, digits - 1); i < Math.pow(10, digits); i++) {
            for (int j = (int) Math.pow(10, digits - 1); j <= i / 3; j++) {
                if (Math.abs((double) i / (double) j - Math.PI) < delta) {
                    delta = Math.abs((double) i / (double) j - Math.PI);
                    numerator = i;
                    denominator = j;
                }
            }

        }
        System.out.println(numerator + " : " + denominator);
        return new PiHolderImpl(numerator, denominator);
    }
}
