package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        if (first == null && second == null) {
            throw new IllegalArgumentException();
        }
        double[] firstDouble = new double[first.size()];
        double[] secondDouble = new double[second.size()];

        Iterator iterator = first.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            firstDouble[i] = (double) ((int) iterator.next());
            i++;
        }
        Iterator iterator2 = second.iterator();
        int k = 0;
        while (iterator2.hasNext()) {
            secondDouble[k] = (double) (int) iterator2.next();
            k++;
        }

        PolynomialFunction polynom1 = new PolynomialFunction(firstDouble);
        PolynomialFunction polynom2 = new PolynomialFunction(secondDouble);
        double[] resultDouble;
        PolynomialFunction polynomRes;

        polynomRes = polynom1.multiply(polynom2);

        resultDouble = polynomRes.getCoefficients();
        int[] resultInt = new int[resultDouble.length];
        Collection<Integer> resultIntArr = new ArrayList<>();

        for (int j = 0; j < resultDouble.length; j++) {
            resultInt[j] = (int) resultDouble[j];
            resultIntArr.add(resultInt[j]);
        }

        return resultIntArr;
    }
}
