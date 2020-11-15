package com.epam.university.java.core.task063;

public class Task063Impl implements Task063 {

    @Override
    public Integer calcDigitalRoot(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        String line = String.valueOf(number);
//        if (line.length() > 1) {
        char[] digits = line.toCharArray();
        for (char digit : digits) {
            int num = Integer.parseInt(String.valueOf(digit));
            sum += num;
        }
        if (String.valueOf(sum).length() > 1) {
            sum = calcDigitalRoot(sum);
        }
//        } else {
//            return number;
//        }
        return sum;
    }
}
