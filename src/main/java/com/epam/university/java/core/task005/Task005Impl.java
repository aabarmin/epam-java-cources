package com.epam.university.java.core.task005;

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
        int top = (int) Math.pow(10, digits);
        int bottom = (int) Math.pow(10, digits - 1);
        double closestToPi = 0.0;
        int denominator = 1;
        int numerator = 1;
        PiHolder piHolder = new PiHolderImpl(1, 1);

        for (denominator = bottom; denominator < top; denominator++) {
            for (numerator = Math.min(top, 3 * denominator);
                 numerator < Math.min(top, 4 * denominator); numerator++) {
                if (closerToPi(closestToPi, (double) numerator / (double) denominator)) {
                    closestToPi = (double) numerator / (double) denominator;
                    piHolder = new PiHolderImpl(numerator, denominator);
                }
            }
        }
        return piHolder;
    }

    /**
     * Method to check whether new number is closer to PI.
     * @param first previous closest to PI.
     * @param second potentially closest to PI.
     * @return true if second is closer to PI than first.
     */
    public boolean closerToPi(double first, double second) {
        double firstDiff = Math.abs(first - Math.PI);
        double secondDiff = Math.abs(second - Math.PI);
        if (secondDiff < firstDiff) {
            return true;
        } else {
            return false;
        }
    }
}
