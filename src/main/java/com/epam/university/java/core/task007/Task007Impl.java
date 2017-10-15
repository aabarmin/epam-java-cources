package com.epam.university.java.core.task007;

import com.epam.university.java.core.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task007Impl implements Task007 {
    private Validator validator = Validator.getInstance();

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        validator.validate(first, second);
        final int[][] coeff = new int[first.size()][first.size() + second.size() - 1];
        int i = 0;
        int j = 0;
        for (Integer firstN : first) {
            for (Integer secondN : second) {
                coeff[i][j++] = firstN * secondN;
            }
            j = ++i;
        }
        final int[] result = new int[first.size() + second.size() - 1];
        for (int k = 0; k < coeff[0].length; k++) {
            result[k] = sumInARow(coeff, k);
        }
        final List<Integer> list = new ArrayList<>();
        for (int q : result) {
            list.add(q);
        }
        return list;
    }

    private int sumInARow(int[][] matrix, int row) {
        int result = 0;
        for (int[] column : matrix) {
            result += column[row];
        }
        return result;
    }
}
