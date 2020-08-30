package com.epam.university.java.core.task001;

<<<<<<< Updated upstream
public class Task001Impl implements Task001{

    @Override
    public double addition(String firstNumber, String secondNumber) throws IllegalArgumentException{
        if (firstNumber == null || secondNumber == null){
=======
public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber)
            throws IllegalArgumentException {
        if (firstNumber == null || secondNumber == null) {
>>>>>>> Stashed changes
            throw new IllegalArgumentException();
        }
        double firstNumberParsed = Double.parseDouble(firstNumber);
        double secondNumberParsed = Double.parseDouble(secondNumber);
        return firstNumberParsed + secondNumberParsed;
    }

    @Override
<<<<<<< Updated upstream
    public double subtraction(String firstNumber, String secondNumber) throws IllegalArgumentException{
        if (firstNumber == null || secondNumber == null){
=======
    public double subtraction(String firstNumber, String secondNumber)
            throws IllegalArgumentException {
        if (firstNumber == null || secondNumber == null) {
>>>>>>> Stashed changes
            throw new IllegalArgumentException();
        }
        double firstNumberParsed = Double.parseDouble(firstNumber);
        double secondNumberParsed = Double.parseDouble(secondNumber);
        return firstNumberParsed - secondNumberParsed;
    }

    @Override
<<<<<<< Updated upstream
    public double multiplication(String firstNumber, String secondNumber) throws IllegalArgumentException{
        if (firstNumber == null || secondNumber == null){
=======
    public double multiplication(String firstNumber, String secondNumber)
            throws IllegalArgumentException {
        if (firstNumber == null || secondNumber == null) {
>>>>>>> Stashed changes
            throw new IllegalArgumentException();
        }
        double firstNumberParsed = Double.parseDouble(firstNumber);
        double secondNumberParsed = Double.parseDouble(secondNumber);
        return firstNumberParsed * secondNumberParsed;
    }

    @Override
<<<<<<< Updated upstream
    public double division(String firstNumber, String secondNumber) throws IllegalArgumentException{
        if (firstNumber == null || secondNumber == null){
=======
    public double division(String firstNumber, String secondNumber)
            throws IllegalArgumentException {
        if (firstNumber == null || secondNumber == null) {
>>>>>>> Stashed changes
            throw new IllegalArgumentException();
        }
        double firstNumberParsed = Double.parseDouble(firstNumber);
        double secondNumberParsed = Double.parseDouble(secondNumber);
        return firstNumberParsed / secondNumberParsed;
    }
}
