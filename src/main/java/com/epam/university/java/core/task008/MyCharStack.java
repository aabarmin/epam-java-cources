package com.epam.university.java.core.task008;

class MyCharStack {
    private int elementCount;
    private StringBuilder items;

    MyCharStack() {
        elementCount = 0;
        items = new StringBuilder();
    }

    boolean isEmpty() {
        return  elementCount == 0;
    }

    void push(char item) {
        elementCount++;
        items.append(item);
    }

    char pop() {
        char item = items.charAt(elementCount - 1);
        items.deleteCharAt(--elementCount);
        return item;
    }
}
