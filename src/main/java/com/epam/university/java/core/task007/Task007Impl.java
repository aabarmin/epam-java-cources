package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;


public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        ArrayList<Integer> newFirst = new ArrayList<>(first);
        ArrayList<Integer> newSecond = new ArrayList<>(second);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < newFirst.size() + newSecond.size() - 1; i++) {
            result.add(0);
        }
        for (int i = 0; i < newFirst.size(); i++) {
            for (int j = 0; j < newSecond.size(); j++) {
                result.set(i + j, result.get(i + j) + newFirst.get(i) * newSecond.get(j));
            }
        }
        return result;
    }
}
