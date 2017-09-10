package com.epam.university.java.core.task007;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Task007Impl implements Task007 {

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        Integer[] resultArr = new Integer[first.size() + second.size()];
        int firstIndex = first.size() - 1;
        int secondIndex = second.size() - 1;

        for (Integer firstValue : first) {
            secondIndex = second.size() - 1;
            for (Integer secondValue : second) {
                if (resultArr[firstIndex + secondIndex] != null) {
                    resultArr[firstIndex + secondIndex] += firstValue * secondValue;
                } else {
                    resultArr[firstIndex + secondIndex] = firstValue * secondValue;
                }
                secondIndex--;
            }
            firstIndex--;
        }
        Collection<Integer> destinationCollection = new ArrayList<>();

        for (int i = resultArr.length - 1; i >= 0; i--) {
            if (resultArr[i] != null) {
                destinationCollection.add(resultArr[i]);
            }

        }

        return destinationCollection;
    }
}
