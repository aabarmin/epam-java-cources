package com.epam.university.java.core.task001;

import com.epam.university.java.core.ChecksHelper;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {

        ChecksHelper.checkForNullBothArguments( firstNumber, secondNumber );
        ChecksHelper.checkForEmptyBothArguments( firstNumber, secondNumber );
        return Double.parseDouble( firstNumber ) + Double.parseDouble( secondNumber );
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {

        ChecksHelper.checkForNullBothArguments( firstNumber, secondNumber );
        ChecksHelper.checkForEmptyBothArguments( firstNumber, secondNumber );
        return Double.parseDouble( firstNumber ) - Double.parseDouble( secondNumber );
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {

        ChecksHelper.checkForNullBothArguments( firstNumber, secondNumber );
        ChecksHelper.checkForEmptyBothArguments( firstNumber, secondNumber );
        return Double.parseDouble( firstNumber ) * Double.parseDouble( secondNumber );
    }

    @Override
    public double division(String firstNumber, String secondNumber) {

        ChecksHelper.checkForNullBothArguments( firstNumber, secondNumber );
        ChecksHelper.checkForEmptyBothArguments( firstNumber, secondNumber );
        return Double.parseDouble( firstNumber ) / Double.parseDouble( secondNumber );
    }
}
