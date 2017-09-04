package com.epam.university.java.core.task001;

/**
 * Created by Daniil Smirnov on 04.09.2017.
 * All copy registered MF.
 */
public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        checkIllegalArgument(firstNumber,secondNumber);
        int[] array = checkParseInt(firstNumber,secondNumber);
        return array[0]+array[1];
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        checkIllegalArgument(firstNumber,secondNumber);
        int[] array = checkParseInt(firstNumber,secondNumber);
        return array[0]-array[1];
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        checkIllegalArgument(firstNumber,secondNumber);
        double[] array = checkParseDouble(firstNumber,secondNumber);
        return array[0]*array[1];
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        checkIllegalArgument(firstNumber,secondNumber);
        double[] array = checkParseDouble(firstNumber,secondNumber);
        return array[0]/array[1];
    }

    private void checkIllegalArgument(String firstNumber, String secondNumber){
        if (firstNumber==null||secondNumber==null){
            throw new IllegalArgumentException();
        }
    }
    private int[] checkParseInt(String firstNumber, String secondNumber){
        int a;
        int b;

        try {
            a = Integer.parseInt(firstNumber.trim());
            b = Integer.parseInt(secondNumber.trim());
        }catch (Exception e){
            throw new NumberFormatException();
        }
        return new int[]{a,b};
    }
    private double[] checkParseDouble(String firstNumber, String secondNumber){
        double a;
        double b;

        try {
            a = Double.parseDouble(firstNumber.trim());
            b = Double.parseDouble(secondNumber.trim());
        }catch (Exception e){
            throw new NumberFormatException();
        }

        return new double[]{a,b};
    }
}
