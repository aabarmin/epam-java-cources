package com.epam.university.java.core.task005;

import com.epam.university.java.core.utils.Validator;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        PiHolderImpl piHolder = new PiHolderImpl(1, 1);
        Validator.validateValueRange(digits, 1, 10,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER, Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);

        double startNumerator = Math.pow(10, digits - 1), endNumerator = Math.pow(10, digits);
        for (double numerator = startNumerator; numerator < endNumerator; numerator++) {
            for (double denominator = startNumerator;
                 denominator <= numerator / Math.round(Math.PI); denominator++) {
                if ((Math.abs((numerator / denominator) - Math.PI)) <
                        Math.abs(piHolder.getNumerator() / piHolder.getDenominator() - Math.PI)) {
                    piHolder.setPiHolder(numerator, denominator);
                }
            }
        }
        return piHolder;
    }
}