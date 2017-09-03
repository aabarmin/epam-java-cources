package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {

        checkForNullBothArguments( firstNumber, secondNumber );
        checkForEmptyBothArguments( firstNumber, secondNumber );
        return Double.parseDouble( firstNumber ) + Double.parseDouble( secondNumber );
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {

        checkForNullBothArguments( firstNumber, secondNumber );
        checkForEmptyBothArguments( firstNumber, secondNumber );
        return Double.parseDouble( firstNumber ) - Double.parseDouble( secondNumber );
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {

        checkForNullBothArguments( firstNumber, secondNumber );
        checkForEmptyBothArguments( firstNumber, secondNumber );
        return Double.parseDouble( firstNumber ) * Double.parseDouble( secondNumber );
    }

    @Override
    public double division(String firstNumber, String secondNumber) {

        checkForNullBothArguments( firstNumber, secondNumber );
        checkForEmptyBothArguments( firstNumber, secondNumber );
        return Double.parseDouble( firstNumber ) / Double.parseDouble( secondNumber );
    }

    // (null, null)
    private void checkForNullBothArguments(String firstNumber, String secondNumber) throws IllegalArgumentException {
        if( null == firstNumber && null == secondNumber )
            throw new IllegalArgumentException();
    }

    // (" ", " ")
    private void checkForEmptyBothArguments(String firstNumber, String secondNumber) throws IllegalArgumentException {
        if( firstNumber.equals(" ") && secondNumber.equals(" ") )
            throw new IllegalArgumentException();
    }
}
