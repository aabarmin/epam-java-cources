package com.epam.university.java.core.task008;

public class MyStack<T> {
    private int size;
    private T[] stack;
    private int top;

    public MyStack(int size) {
        this.size = size;
        stack = (T[]) (new Object[size]);
        top = -1;
    }

    public void push(T element) {
        stack[++top] = element;
    }

    public T pop() {
        return stack[top--];
    }

    public T lookTop() {
        return stack[top];
    }

    public boolean isEmtpy() {
        return top == -1;
    }
}
