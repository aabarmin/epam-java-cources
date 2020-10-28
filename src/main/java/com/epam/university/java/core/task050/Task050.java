package com.epam.university.java.core.task050;

import java.util.Map;

/**
 * Knapsack problem.
 *
 * <p>
 *      Given N items, Ni item has mass Wi > 0 and cost Pi > 0.
 *      It is necessary to choose from these items such a set
 *      so that the total mass does not exceed the given
 *      value W (the capacity of the backpack),
 *      and the total cost is maximum.
 * </p>
 */
public interface Task050 {

    /**
     * Calculate maximum cost of the items in backpack.
     * @param size size of the backpack.
     * @param items map with cost as keys and weight as values of each item.
     * @return maximum cost
     */
    double calculate(int size, Map<Double, Double> items);
}
