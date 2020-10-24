package com.epam.university.java.core.task050;

import java.util.Map;
import java.util.TreeMap;

public class Task050Impl implements Task050 {
    @Override
    public double calculate(int size, Map<Double, Double> items) {
        if (items == null || size <= 0) {
            throw new IllegalArgumentException();
        }

        double maxCost = 0.0;
        double totalWeight = 0.0;

        TreeMap<Double, Double> pricePerKilo = new TreeMap<>();

        for (Map.Entry<Double, Double> item : items.entrySet()) {
            double cost = item.getKey();
            double weight = item.getValue();

            pricePerKilo.put(cost / weight, cost);
        }


        while (totalWeight < size && pricePerKilo.size() != 0) {
            double maxPricePerKilo = pricePerKilo.lastKey();


            if (totalWeight + items.get(pricePerKilo.get(maxPricePerKilo)) < size) {
                maxCost += pricePerKilo.get(maxPricePerKilo);
                totalWeight += items.get(pricePerKilo.get(maxPricePerKilo));
                pricePerKilo.remove(maxPricePerKilo);
            } else {
                maxCost += (size - totalWeight) * maxPricePerKilo;
                totalWeight = size;
            }
        }



        return Math.round(maxCost * 1000.0) / 1000.0;
    }
}
