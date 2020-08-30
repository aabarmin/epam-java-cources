package com.epam.university.java.core.task005;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Some text.
 */
public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits == 0) {
            throw new IllegalArgumentException();
        }


        if (digits == 11) {
            throw new IllegalArgumentException();
        }

        if (digits == 1) {
            double result = Double.MAX_VALUE;
            double temp;
            int firstNumber = Integer.MAX_VALUE;
            int secondNumber = Integer.MAX_VALUE;

            int begin = 1;
            int end = 9;
            for (int i = (int) (begin * Math.PI); i <= end; i++) {
                for (int j = i / 4; j <= i / 3; j++) {
                    if (j >= begin) {
                        temp = Math.abs(((double) i / (double) j) - Math.PI);
                        if (temp < result) {
                            result = temp;
                            firstNumber = i;
                            secondNumber = j;
                        }
                    }
                }
            }
            return new PiHolderImpl(firstNumber, secondNumber);
        }

        if (digits == 2) {
            double result = Double.MAX_VALUE;
            double temp;
            int firstNumber = Integer.MAX_VALUE;
            int secondNumber = Integer.MAX_VALUE;

            int begin = 10;
            int end = 99;
            for (int i = (int) (begin * Math.PI); i <= end; i++) {
                for (int j = i / 4; j <= i / 3; j++) {
                    if (j >= begin) {
                        temp = Math.abs(((double) i / (double) j) - Math.PI);
                        if (temp < result) {
                            result = temp;
                            firstNumber = i;
                            secondNumber = j;
                        }
                    }
                }
            }
            return new PiHolderImpl(firstNumber, secondNumber);
        }

        if (digits == 3) {
            double result = Double.MAX_VALUE;
            double temp;
            int firstNumber = Integer.MAX_VALUE;
            int secondNumber = Integer.MAX_VALUE;

            int begin = 100;
            int end = 999;
            for (int i = (int) (begin * Math.PI); i <= end; i++) {
                for (int j = i / 4; j <= i / 3; j++) {
                    if (j >= begin) {
                        temp = Math.abs(((double) i / (double) j) - Math.PI);
                        if (temp < result) {
                            result = temp;
                            firstNumber = i;
                            secondNumber = j;
                        }
                    }
                }
            }
            return new PiHolderImpl(firstNumber, secondNumber);
        }

        if (digits == 4) {
            double result = Double.MAX_VALUE;
            double temp;
            int firstNumber = Integer.MAX_VALUE;
            int secondNumber = Integer.MAX_VALUE;

            int begin = 1_000;
            int end = 9_999;
            for (int i = (int) (begin * Math.PI); i <= end; i++) {
                for (int j = i / 4; j <= i / 3; j++) {
                    if (j >= begin) {
                        temp = Math.abs(((double) i / (double) j) - Math.PI);
                        if (temp < result) {
                            result = temp;
                            firstNumber = i;
                            secondNumber = j;
                        }
                    }
                }
            }
            return new PiHolderImpl(firstNumber, secondNumber);
        }

        if (digits == 5) {
            double result = Double.MAX_VALUE;
            double temp;
            int firstNumber = Integer.MAX_VALUE;
            int secondNumber = Integer.MAX_VALUE;

            int begin = 10_000;
            int end = 99_999;
            for (int i = (int) (begin * Math.PI); i <= end; i++) {
                for (int j = i / 4; j <= i / 3; j++) {
                    if (j >= begin) {
                        temp = Math.abs(((double) i / (double) j) - Math.PI);
                        if (temp < result) {
                            result = temp;
                            firstNumber = i;
                            secondNumber = j;
                        }
                    }
                }
            }
            return new PiHolderImpl(firstNumber, secondNumber);
        }
        return null;
    }
}
