package com.epam.university.java.core.task005;

public class Task005Impl implements  Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 10) {
            throw  new IllegalArgumentException();
        }
         double min= 5;
         int left = (int)(Math.pow(10,digits-1));
         if (digits == 1) {
             left = 1;
         }
         int right = (int)(Math.pow(10,digits));
         int minSecond = 0;
         int minFirst = 0;
         int tmp;
        for (int i = left; i < right; i++) {
            tmp= (int)Math.round(i*Math.PI);
            if (tmp<right) {
                if (Math.abs(((double)tmp / i) - Math.PI) < min) {
                    minFirst = tmp;
                    minSecond = i;
                    min = Math.abs(((double)tmp / i) - Math.PI);
                }
            }
            }
        for (int i = right; i >left ; i--) {
            tmp= (int)Math.round(i/Math.PI);
            if (tmp>left) {
                if (Math.abs((((double)i) / tmp) - Math.PI) < min) {
                    minFirst = i;
                    minSecond = tmp;
                    min = Math.abs(((double)i / tmp) - Math.PI);
                }
            }
        }

        return simplify(new PiHolderImpl(minFirst,minSecond), digits);
    }

    /**
     * Simplifies numbers, saving their's quotient with condition of saving count of digits.
     * @param piHolder
     * @return returns new piHolder with same quotinent.
     */
    public PiHolder simplify(PiHolder piHolder, int digits) {
        int minValue = (int)Math.pow(10,(digits-1));
        int newFirstValue= piHolder.getFirst();
        int newSecondValue = piHolder.getSecond();
        for (int i = 9; i >1; i--) {
            if (newFirstValue % i == 0 && newSecondValue % i == 0) {
                if (newFirstValue / i > minValue && newSecondValue / i > minValue){
                    newFirstValue = newFirstValue / i;
                    newSecondValue = newSecondValue / i;
                }
            }
        }
        return  new PiHolderImpl(newFirstValue,newSecondValue);
    }
}
