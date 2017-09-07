package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits<=0) throw new IllegalArgumentException();
        int firstNumber = (int)Math.pow(10,digits-1);
        int lastNumber = (int)(Math.pow(10,digits)-1);
        double min = Double.MAX_VALUE;
        double first = 0;
        double second = 0;
        double current;
        for (double i = firstNumber; i<=lastNumber; i++ ){
            for (double j = firstNumber; j<i; j++){
                current = Math.abs(i-Math.PI*j);
                if (current<min){
                    min = current;
                    first = i;
                    second = j;
                }
            }
        }
        PiHolder result = new PiHolderImpl((int)first,(int)second);
        return result;
    }
}
