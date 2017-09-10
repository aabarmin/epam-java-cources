package com.epam.university.java.core.task008;

import java.util.ArrayList;

public class HandMadeStack<T> implements ParamStack<T> {
    private ArrayList<T> list;

    HandMadeStack() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean push(T t) {
        return list.add(t);
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

    public T pop() {
        return list.remove(list.size() - 1);
    }
}
