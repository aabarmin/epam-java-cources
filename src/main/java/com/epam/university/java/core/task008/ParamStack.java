package com.epam.university.java.core.task008;

public interface ParamStack<T> {
    boolean isEmpty();

    boolean push(T t);

    T peek();

    T pop();
}
