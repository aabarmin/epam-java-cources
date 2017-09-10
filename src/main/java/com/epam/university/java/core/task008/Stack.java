package com.epam.university.java.core.task008;

/**
 * Stack data structure.
 *
 * @param <T> type of elements that hold this stack
 */
public interface Stack<T> {

    /**
     * Push new element on top of the stack.
     *
     * @param element new element for stack to hold
     */
    void push(T element);

    /**
     * Get element from top of the stack.
     *
     * @return if where is no elements, return null
     */
    T pop();

}
