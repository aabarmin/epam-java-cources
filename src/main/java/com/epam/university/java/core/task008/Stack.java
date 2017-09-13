package com.epam.university.java.core.task008;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Simple array based implementation of the stack data structure.
 * @param <E> type of the stack elements
 */
public class Stack<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public Stack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Insert element to the stack.
     *
     * @param e element
     */
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * Get element that was added last and remove it from stack.
     *
     * @return last inserted element
     * @throws EmptyStackException if stack is empty
     */
    @SuppressWarnings("unchecked")
    public E pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }

    /**
     * Tests if this stack has no elements.
     *
     * @return  {@code true} if and only if this stack has
     *          no elements, that is, its size is zero;
     *          {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }
}
