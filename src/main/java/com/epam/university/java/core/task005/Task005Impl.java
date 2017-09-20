package com.epam.university.java.core.task005;

import java.lang.Math;

/**
 * implementation class for task005.
 *
 * @author Sergei Titov
 */
public class Task005Impl implements Task005 {

    protected int getDivisor(int digits) {
        int retVal = 1;
        for (int i = 1; i < digits; i++) {
            retVal *= 10;
        }

        return retVal;
    }


    /**
     * Find two numbers, quotient of which will be closest to PI number. Ex. if digit is 1,
     * holder values should be between 1 and 9, if digits is equals to 2, values should
     * be between 10 and 99 and so on.
     *
     * @param digits amount of digits in numbers.
     *
     * @return holder which contains both numbers
     *
     * @throws IllegalArgumentException if digits less or equals to the zero, or more than ten
     */
    @Override
    public PiHolder findPi(int digits) throws IllegalArgumentException {

        if (digits > 10 || digits < 1) {
            throw new IllegalArgumentException();
        }

        // min and max borders for first and second
        int minDivisor = getDivisor(digits);
        int maxDividend = minDivisor * 10;

        // best values
        int bestDivisor = minDivisor;
        int bestDividend = (int)(minDivisor * Math.PI);
        double bestPiDiff = bestDividend / bestDivisor;

        // temp variables
        int dividendLow = 3; // just to init with something
        int dividendHi = 4;  // so we could start calculating
        double diff;
        double quotientLow;
        double quotientHi;

        // loop searching for closest value
        for (int i = minDivisor; dividendHi < maxDividend; i++) {

            // calculate the difference with PI
            dividendLow = (int)(i * Math.PI);
            dividendHi = dividendLow + 1;
            quotientLow = (double)dividendLow / i;
            quotientHi = (double)dividendHi / i;
            diff = Math.min(Math.PI - quotientLow, quotientHi - Math.PI);

            // if we just found a closer value
            if (diff < bestPiDiff) {
                bestPiDiff = diff;
                bestDivisor = i;
                bestDividend = Math.PI - quotientLow < quotientHi - Math.PI
                        ? dividendLow : dividendHi;
            }
        }

        return new PiHolderImpl(bestDividend, bestDivisor);
    }
}
