package com.epam.university.java.core.task008;

import java.util.Stack;

public class MyStack<T> {
    private int size;
    private T[] stack;
    private int top;

    /**
     * /**
     * Creates an empty Stack.
     *
     * @param size size of array
     */
    public MyStack(int size) {
        this.size = size;
        stack = (T[]) (new Object[size]);
        top = -1;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element the item to be pushed onto this stack.
     */
    public void push(T element) {
        stack[++top] = element;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack.
     */
    public T pop() {
        return stack[top--];
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return The object at the top of this stack.
     */
    public T lookTop() {
        return stack[top];
    }

    /**
     * Tests if this stack is empty.
     *
     * @return <code>true</code> if this stack contains no items;
     * <code>false</code> otherwise.
     */
    public boolean isEmtpy() {
        return top == -1;
    }
}
