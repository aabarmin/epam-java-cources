package com.epam.university.java.core.task022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Task022Impl implements Task022 {

    @Override
    public int maxSum(Collection<Integer> numbers) {
        ArrayList<Integer> list = new ArrayList<>(numbers);
        int sum = 0;
        int min = list.get(0);
        for (Integer element : list){
            if (min > element){
                min = element;
            }
        }
        for (Integer element : list){
            if (element != min){
                sum += element;
            }
        }

        return sum;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        ArrayList<Integer> list = new ArrayList<>(numbers);
        int sum = 0;
        int max = list.get(0);
        for (Integer element : list){
            if (max < element){
                max = element;
            }
        }
        for (Integer element : list){
            if (element != max){
                sum += element;
            }
        }
        return sum;
    }
}
