package com.epam.university.java.core.task014;

import java.util.ArrayList;

public class VampireNumberFactoryImpl implements VampireNumberFactory {

    @Override
    public VampireNumber newInstance(int multiplication, int first, int second) {


        ArrayList<Integer> digits = new ArrayList<>();
        String number = multiplication + "";
        for (int i = 0; i < number.length(); i++){
            int digit = Integer.parseInt(number.substring(i, i + 1));
            digits.add(digit);
        }
        int lastDigit = digits.get(digits.size() - 1);
        String firstNumber;
        String secondNumber;
        for (int x2 : digits){
            for (int x4 : digits){
                if (x2*x4 > 10){
                    if ((x2*x4) % 10 == lastDigit){
                        firstNumber = x2 + "";
                        secondNumber = x4 + "";
                    }
                }
                if (x2*x4 < 10){
                    if ((x2*x4) == lastDigit){
                        firstNumber = x2 + "";
                        secondNumber = x4 + "";
                    }
                }
                if (x2*x4 == 10){
                        firstNumber = 2 + "";
                        secondNumber = 5 + "";
                }
            }
        }
        return null;
    }
}
