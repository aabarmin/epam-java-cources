package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        // Calculating maximum degree for the result 
        int maxIndex = first.size() + second.size() - 1;

        // Casting collections to Arrays
        Integer[] firstArr = (Integer[]) first.toArray();
        Integer[] secondArr = (Integer[]) second.toArray();

        // Creating the result array
        int[] result = new int[maxIndex];
        
        // Calculating result polynomial
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {

                int currIndex = i + j;
                int multiplied = firstArr[i] * secondArr[j];
                
                if (multiplied != 0) {
                    result[currIndex] = (result[currIndex] == 0)
                            ? (multiplied)
                            : (result[currIndex] * multiplied);
                }
            }
        }

        // Casting result to List
        List<Integer> resultList = new ArrayList<>();
        for (int currValue : result) {
            resultList.add(currValue);
        }
        
        return resultList;
    }
}
