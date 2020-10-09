package com.epam.university.java.core.task046;

import java.util.List;

/**
 * it is necessary to assemble a matryoshka consisting of n dolls.
 * Find all possible combinations if you take K dolls each time.
 * Assembly is only possible if the smaller doll goes before the larger doll.
 * The dolls are numbered from 0 to n-1 in ascending order.
 */
public interface Task046 {

    /**
     * List of strings , each containing k numbers of dolls from smaller to larger
     * separated by space.
     *
     * @param k the number of dolls that can be taken at a time
     * @param n total number of nesting dolls
     * @return List of strings , each containing k numbers of dolls from smaller to larger
     */
    List<String> assembleMatryoshka(Integer k, Integer n);
}
