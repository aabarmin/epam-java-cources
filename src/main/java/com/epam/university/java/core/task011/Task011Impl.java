package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        int size = collection.length;

        // Return first element if collection is too small
        if (size == 1) {
            return collection[0];
        }

        // Index of element to return
        int index = getElementIndex(size);

        return collection[index];
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        int size = collection.size();

        // Return first element if collection is too small
        if (size == 1) {
            return collection.get(0);
        }

        // Index of element to return
        int index = getElementIndex(size);

        return collection.get(index);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        int size = collection.size();

        // Return first element if collection is too small
        if (size == 1) {
            return collection.get(0);
        }

        // Index of element to return
        int index = getElementIndex(size);

        return collection.get(index);
    }

    /**
     * Calculating index of element to return by the size of collection.
     * <p>
     *     Tip: With increasing size of collection by 1 - returning index increasing by 2.
     * </p>
     *
     * @param size size of collection
     * @return index of element to return
     */
    private int getElementIndex(int size) {
        
        // Calculating nearest size of collection which returns second element of collection
        double power = Math.ceil(Math.log10(size) / Math.log10(2)) - 1;
        double intervalStart = Math.pow(2, power) + 1;

        // Calculating index of element to return
        return (int) (((size - intervalStart) + 1) * 2) - 1;
    }
}
