package com.epam.university.java.core.task007;

import java.util.*;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {

        if (first == null || second == null){
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> fPol = new ArrayList<>(first);
        ArrayList<Integer> sPol = new ArrayList<>(second);

        int[] prod = new int[fPol.size() + sPol.size() - 1];

        for (int i = 0; i < fPol.size(); i++) {
            for (int j = 0; j < sPol.size(); j++) {
                prod[i + j] += fPol.get(i) * sPol.get(j);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : prod) {
            list.add(num);
        }

        return list;
    }
}
