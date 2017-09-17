package com.epam.university.java.core.task005;

import com.epam.university.java.core.validations.CheckArgument;

/**
 * Created by Dremina on 10.09.2017.
 */
public class Task005Impl implements Task005 {


    @Override
    public PiHolder findPi(int digits) {
        CheckArgument.validateNullValue(digits);
        CheckArgument.notNull(digits);
        CheckArgument.notNegative(digits);
        CheckArgument.moreThanTen(digits);

        return new PiHolderImpl(digits);
    }


}
