package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ilya on 16.09.17.
 */
public class Task014Impl implements Task014 {


    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        List<Integer> range = IntStream.range(1000, 10000)
            .collect(ArrayList<Integer>::new, (l, i) -> l.add(i), ArrayList::addAll);

        Collection<VampireNumber> result = range.stream().flatMap(n -> {
            List<Integer> digits = getDigits(n);
            List<List<Integer>> variants = getVariants(digits);
            List<VampireNumber> possible = variants.stream()
                .map((l) -> new VampireNumberImpl(l.get(0), l.get(1), n))
                .collect(Collectors.toList());
            return possible.stream();
        }).filter(n -> checkVampire(n)).collect(
            Collectors.toSet());

        return result;
    }

    private List<Integer> getDigits(int number) {
        String digits = Integer.toString(number);

        List<Integer> collect = Stream.of(digits.split("")).mapToInt(s -> Integer.parseInt(s))
            .collect(ArrayList<Integer>::new, (l, i) -> l.add(i), ArrayList::addAll);

        return collect;
    }

    private List<List<Integer>> getVariants(Collection<Integer> digits) {
        if (digits.size() != 4) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> variants = new ArrayList<>();

        int counter = 1;
        Map<Integer, Integer> digitsMap = new HashMap<>();
        for (int digit :
            digits) {
            digitsMap.put(counter, digit);
            counter++;
        }

        for (int i = 1; i < digits.size(); i++) {
            int digit = digitsMap.get(i);
            for (int j = i + 1; j <= digits.size(); j++) {
                int digitSecond = digitsMap.get(j);
                int numberFirstVar1 = digit * 10 + digitSecond;
                int numberFirstVar2 = digitSecond * 10 + digit;
                List<Integer> othes = new ArrayList<>();
                for (int k = 1; k <= digits.size(); k++) {
                    if (k != i && k != j) {
                        othes.add(k);
                    }
                }
                int numberSecondVar1 =
                    digitsMap.get(othes.get(1)) * 10 + digitsMap.get(othes.get(0));
                int numberSecondVar2 =
                    digitsMap.get(othes.get(0)) * 10 + digitsMap.get(othes.get(1));
                variants.add(Arrays.asList(numberFirstVar1, numberSecondVar1));
                variants.add(Arrays.asList(numberFirstVar2, numberSecondVar1));
                variants.add(Arrays.asList(numberFirstVar1, numberSecondVar2));
                variants.add(Arrays.asList(numberFirstVar2, numberSecondVar2));
            }
        }

        return variants;
    }

    private boolean checkVampire(VampireNumber number) {
        return number.getMultiplication() == number.getFirst() * number.getSecond();
    }


}
