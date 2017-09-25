package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TestList {
    public static Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {



        Integer[] arr = new Integer[first.size() + second.size() - 1];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 0;
        }

        ArrayList<Integer> firstAsArrayList = new ArrayList<Integer>(first);
        Collections.reverse(firstAsArrayList);



        ArrayList<Integer> secondAsArrayList = new ArrayList<Integer>(second);
        Collections.reverse(secondAsArrayList);




        for (int i = 0; i < firstAsArrayList.size(); i++){
            //int index = i;
            for(int j = 0; j < secondAsArrayList.size(); j++){
                int current;
                current = firstAsArrayList.get(i)*secondAsArrayList.get(j);
                arr[i + j] = arr[i + j] + current;
                //index++;
            }

        }
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(arr));



        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        final Collection<Integer> first = Arrays.asList(2, 0, 0, 3);
        final Collection<Integer> second = Arrays.asList(4, 0, 1);

        for (Integer element: first) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (Integer element: second) {
            System.out.print(element + " ");
        }
        System.out.println();

        for (Integer element: multiplyPolynomial(first, second)) {
            System.out.print(element + " ");
        }
    }
}
