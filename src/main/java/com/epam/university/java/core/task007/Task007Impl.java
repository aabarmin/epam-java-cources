package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Вера on 11.09.2017.
 */
public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        int n = first.size() - 1; // степень первого полинома
        int m = second.size() - 1; // степень второго полинома
        // пусть d[i] - коэффициенты полинома, полученного перемножение первого и второго полинома
        // тогда коэффициент d[i] находим следующим образом: = сумма по всем (k + l = i) a[k], b[l]
        // где a[k] - элементы первого массива, b[l] - второго
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        Collection<Integer> result = new ArrayList<>();

        for (Integer f: first ) {
            firstList.add(f);
        }
        for (Integer s: second ) {
            secondList.add(s);
        }

        int d;
        for (int i = m + n; i > -1; i--) {
            d = 0;

            for (int j = 0; j < firstList.size(); j++) {
                for (int k = 0; k < secondList.size(); k++) {
                    if (j + k == m + n - i) {
                        d = d + firstList.get(j)*secondList.get(k);
                    }
                }
            }
            result.add(d);
        }

        return result;
    }
}
