package com.epam.university.java.core.task073;

import java.util.List;

/**
 * In this task you should calculate ratios of elements that are positive, negative and zeroes.
 */
public interface Task073 {
    /**
     * Function to calculate the numbers.
     * @param listOfNumbers list of input numbers;
     * @return collection of ratios.
     */
    List<Double> countOfRatios(List<Integer> listOfNumbers);
}
