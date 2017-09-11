package com.epam.university.java.core.task001;

import java.util.Objects;

public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber) {


        if((firstNumber==null&&secondNumber==null)||(Objects.equals(firstNumber, " ") && Objects.equals(secondNumber, " "))){
            throw new IllegalArgumentException();
        }
        else if(firstNumber.matches("^[a-zA-z_-]$")||secondNumber.matches("^[a-zA-z_-]$"))
        {
            throw new NumberFormatException();
        }

        return Integer.parseInt(firstNumber.trim())+Integer.parseInt(secondNumber.trim());
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {

        if((firstNumber==null&&secondNumber==null)||(Objects.equals(firstNumber, " ") && Objects.equals(secondNumber, " "))){
            throw new IllegalArgumentException();
        }
        else if(firstNumber.matches("^[a-zA-z_-]$")||secondNumber.matches("^[a-zA-z_-]$"))
        {
            throw new NumberFormatException();
        }

        return Integer.parseInt(firstNumber.trim())-Integer.parseInt(secondNumber.trim());
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {

        if((firstNumber==null&&secondNumber==null)||(Objects.equals(firstNumber, " ") && Objects.equals(secondNumber, " "))){
            throw new IllegalArgumentException();
        }
        else if(firstNumber.matches("^[a-zA-z_-]$")||secondNumber.matches("^[a-zA-z_-]$"))
        {
            throw new NumberFormatException();
        }
        else{
            return Double.parseDouble(firstNumber.trim())*Double.parseDouble(secondNumber.trim());
        }


    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        if((firstNumber==null&&secondNumber==null)||(Objects.equals(firstNumber, " ") && Objects.equals(secondNumber, " "))){
            throw new IllegalArgumentException();
        }
        else if(firstNumber.matches("^[a-zA-z_-]$")||secondNumber.matches("^[a-zA-z_-]$"))
        {
            throw new NumberFormatException();
        }
        else if(secondNumber.trim().equals("0")&&firstNumber.trim().equals("0")){
            return Double.NaN;
        }
        else if(secondNumber.trim().equals("0")&&firstNumber.trim().equals("1")){
            return Double.POSITIVE_INFINITY;
        }
        else if(secondNumber.trim().equals("0")&&firstNumber.trim().equals("-1")){
            return Double.NEGATIVE_INFINITY;
        }
        else{
            return Double.parseDouble(firstNumber.trim())/Double.parseDouble(secondNumber.trim());
        }
    }
}
