package com.epam.university.java.core.task072;

public interface Task072 {

    /**
     * Task072.
     * In this task you need to implement some methods
     * using varargs.
     * I hope you will get in touch
     * with it and the process of getting the topic
     * won't be hard and boring.
     * <p>
     * Have fun :)
     */

    /**
     * Method that finds an average number.
     *
     * @param numbers some numbers
     * @returns an average number
     */
    double averageNum(Integer... numbers);

    /**
     * Method that finds the longest word.
     *
     * @param words some words
     * @returns the longest word
     */
    String theLongestWord(String... words);

    /**
     * Method that finds a result of boolean
     * operation
     *
     * @param operation logical operation
     * @param values    boolean values
     * @return a result of operation
     */
    boolean logicalOperations(String operation, Boolean... values);
}