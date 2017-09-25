package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implementation class for Task014.
 *
 * @author Sergei Titov
 */
public class Task014Impl implements Task014 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<VampireNumber> getVampireNumbers() {

        List<VampireNumber> list = new ArrayList<>();

        for (int i = 11; i < 99; i++) {
            for (int j = i; j < 99; j++) {
                final int product = i * j;
                if (product < 1000) {
                    continue;
                }
                if (product > 9999) {
                    break;
                }

                // product digits
                List<Integer> productDigits = new ArrayList<>();
                productDigits.add(product / 1000);
                productDigits.add((product % 1000) / 100);
                productDigits.add((product % 100)  / 10);
                productDigits.add(product % 10);

                // factors' digits
                List<Integer> factorsDigits = new ArrayList<>();
                factorsDigits.add(i % 10);
                factorsDigits.add(j % 10);
                factorsDigits.add(i / 10);
                factorsDigits.add(j / 10);

                // compare digits
                Collections.sort(productDigits);
                Collections.sort(factorsDigits);
                if (productDigits.equals(factorsDigits)) {
                    list.add(new VampireNumberImpl(product, i, j));
                }
            }
        }
        return list;
    }
}
