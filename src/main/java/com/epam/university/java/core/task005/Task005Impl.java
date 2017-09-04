package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    /**
     * Find two numbers, quotient of which will be closest to PI number. Ex. if digit is 1,
     * holder values should be between 1 and 9, if digits is equals to 2, values should
     * be between 10 and 99 and so on.
     * <p>
     * Tip: Math.abs((a / b) - Math.PI) -> min
     *
     * @param digits amount of digits in numbers.
     * @return holder which contains both numbers
     * @throws IllegalArgumentException if digits less or equals to the zero, or more than ten
     */
    @Override
    public PiHolder findPi(int digits) {

        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException();
        }

        int maxA    = (int) (Math.pow(10, digits) - 1 > Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.pow(10, digits) - 1);
        int b       = (int) Math.pow(10, digits - 1);

        double minDiff = 1.0;
        PiHolder piHolder = new PiHolderImpl(maxA, b);

        do {

            double result = b * Math.PI;
            long a = Math.round(result);

            if (a > maxA) {
                break;
            }

            double diff = Math.abs(result - a);

            if (diff < minDiff) {
                minDiff = diff;
                piHolder = new PiHolderImpl((int) a, b);
            }

            b++;

        } while (true);

        return piHolder;

    }
}
