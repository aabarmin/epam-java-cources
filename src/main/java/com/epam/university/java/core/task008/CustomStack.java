package com.epam.university.java.core.task008;

import java.util.Iterator;

public class CustomStack<T> {

    private T value;
    private CustomStack<T> nextRow;

    private CustomStack(T newValue, CustomStack<T> prevRow) {
        value = newValue;
        nextRow = prevRow;
    }

    public CustomStack() {
    }

    ;

    public T getValue() {
        return value;
    }

    public CustomStack<T> push(T newValue) {
        return new CustomStack<>(newValue, this);
    }

    public CustomStack<T> pop() {
        return nextRow;
    }

    public boolean hasNext() {
        return nextRow != null;
    }


}
