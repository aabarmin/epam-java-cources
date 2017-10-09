package com.epam.university.java.core.task023;

public class Task023Impl implements Task023 {

    @Override
    public String extract(String phoneString) {
        String operatorCode = null;
        String telNumber = "";
        String[] numbers = phoneString.split("[^0-9]+");

        for (int i = 0; i < numbers.length; i++){
            telNumber += numbers[i];
        }
        if (telNumber.length() < 11){
            throw new IllegalArgumentException();
        }
        operatorCode = telNumber.substring(1, 4);
        return operatorCode;
    }
}
