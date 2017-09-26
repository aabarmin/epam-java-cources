package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        byte resultPolyOrder = (byte) (first.size() + second.size() - 1);
        HashMap<Integer, Integer> resultPoly = new HashMap<>();
        int order;
        int orderFirst = resultPolyOrder;

        for (Integer i: first) {
            order = orderFirst;
            for (Integer j: second) {
                if (resultPoly.containsKey(order)) {
                    int oldValue = resultPoly.get(order);
                    int newValue = oldValue + i * j;
                    resultPoly.replace(order, oldValue, newValue);
                } else {
                    resultPoly.put(order, i * j);
                }
                order--;
            }
            orderFirst--;
        }

        Collection<Integer> resultInt = new ArrayList<>();

        for (int i = resultPolyOrder; i > 0; i -- ) {
            resultInt.add(resultPoly.get(i));
        }
        return resultInt;
    }
}
