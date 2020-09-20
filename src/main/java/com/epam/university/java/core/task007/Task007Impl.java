package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author Dmitry Novikov.
 */
public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(
            Collection<Integer> first, Collection<Integer> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        List<Polynominal> firstPolinominal = new ArrayList<>();
        List<Polynominal> secondPolinominal = new ArrayList<>();
        List<Polynominal> result = new ArrayList<>();
        int firstMaxPower = first.size() - 1;
        int secondMaxPower = second.size() - 1;

        for (Integer i : first) {
            if (i != 0) {
                firstPolinominal.add(new Polynominal(i, firstMaxPower));
                firstMaxPower--;
            } else {
                firstMaxPower--;
            }
        }

        for (Integer i : second) {
            if (i != 0) {
                secondPolinominal.add(new Polynominal(i, secondMaxPower));
                secondMaxPower--;
            } else {
                secondMaxPower--;
            }
        }

        for (int i = 0; i < firstPolinominal.size(); i++) {
            for (int j = 0; j < secondPolinominal.size(); j++) {
                int number = (firstPolinominal.get(i).getNumber()
                        * secondPolinominal.get(j).getNumber());
                int power = (firstPolinominal.get(i).getPower()
                        + secondPolinominal.get(j).getPower());
                result.add(new Polynominal(number, power));
            }
        }

        List<Polynominal> result2 = new ArrayList<>();
        int summ = 0;

        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(i).getPower() == result.get(j).getPower()) {
                    summ = result.get(i).getNumber() + result.get(j).getNumber();
                    result.remove(j);
                }
            }
            if (summ > 0) {
                result2.add(new Polynominal(summ, result.get(i).getPower()));
                summ = 0;
            } else {
                result2.add(result.get(i));
            }
        }

        List<Integer> newResult = new ArrayList<>();
        newResult.add(result2.get(0).getNumber());
        for (int i = 1; i < result2.size(); i++) {
            int currentPower = result2.get(i).getPower();
            int previousPower = result2.get(i - 1).getPower();
            int difference = previousPower - currentPower;
            while (difference > 1) {
                newResult.add(0);
                difference--;
            }
            newResult.add(result2.get(i).getNumber());
        }
        return newResult;
    }
}


