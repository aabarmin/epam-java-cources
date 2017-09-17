package com.epam.university.java.core.task007;

import com.epam.university.java.core.validations.CheckArgument;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Dremina on 16.09.2017.
 */
public class Task007Impl implements Task007 {


    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        CheckArgument.validateNullValue(first);
        CheckArgument.validateNullValue(second);
        int factor, power;
        int powerOfFirst = first.size() - 1;

        Integer[] result = new Integer[first.size() + second.size() - 1];

//        first Collection
        for (Iterator iterator1 = first.iterator(); iterator1.hasNext();) {
           int firstCollectionValue = (int) iterator1.next();
           int powerOfSecond = second.size() - 1;

//           second Collection
            for (Iterator iterator2 = second.iterator(); iterator2.hasNext();) {
                int secondCollectionValue = (int) iterator2.next();
                factor = firstCollectionValue * secondCollectionValue;
                power = result.length - (powerOfFirst + powerOfSecond + 1);

                if (result[power] == null) {
                    result[power] = factor;
                } else {
                    result[power] = result[power] + factor;
                }
                powerOfSecond--;

            }
            powerOfFirst--;
        }


        return Arrays.asList(result);
    }
}
