package com.epam.university.java.core.task001;

import com.epam.university.java.core.validations.CheckArgument;

/**
 * Created by Dremina on 02.09.2017.
 */
public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {

        Double sum = stringToNumber(firstNumber) + stringToNumber(secondNumber);
        return sum;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber){

            double sub = stringToNumber(firstNumber) - stringToNumber(secondNumber);;
            return sub;

    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        double mult = stringToNumber(firstNumber) * stringToNumber(secondNumber);;
        return mult;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        double divider = stringToNumber(secondNumber);
        return stringToNumber(firstNumber) / divider;
    }


    private double stringToNumber(String value){
        CheckArgument.validateValue(value);
        return Double.parseDouble(value);

    }
}
