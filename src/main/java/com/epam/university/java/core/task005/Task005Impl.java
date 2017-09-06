package com.epam.university.java.core.task005;

import com.epam.university.java.core.validation.Validator;
import static java.lang.Math.*;

/**
 * Created by Александр on 06.09.2017.
 */
public class Task005Impl implements Task005 {
    private static Validator VALIDATOR = Validator.newInstance(Task005Impl.class);


    /**
     * Find two numbers, quotient of which will be closest to PI number. Ex. if digit is 1,
     * holder values should be between 1 and 9, if digits is equals to 2, values should
     * be between 10 and 99 and so on.
     * <p>
     * Tip: Math.abs((a / b) - Math.PI) -> min
     *
     * @param digits amount of digits in numbers.
     * @return holder which contains both numbers
     * @throws IllegalArgumentException if digits less or equals to the zero, or more than ten
     */
    @Override
    public PiHolder findPi(int digits) {
        VALIDATOR.validNum(digits, (Integer num) -> ((num > 0) && (num < 10)));

        int b = toIntExact(round(pow(10,digits-1))); // init with min value. if digit = 2, minB = 10
        int a = toIntExact(round(b*PI)); // init with min value if minB = 2, minA ~ 31
        int maxA = toIntExact(round(pow(10,digits)));

        double currMinDelta = PI;
        PiHolder currPi = null;

        do{
            double currDelta = abs((a / Double.valueOf(b)) - PI);
            if (currDelta < currMinDelta){
                currPi = new PiHolderImpl(a,b);
                currMinDelta = currDelta;
            }
            a++;
            b = toIntExact(round(a / PI));
        }while (a < maxA);

        return currPi;
    }
}
