package com.epam.university.java.core.task039;

public class Node {
    private int value;
    private Character valueChar;
    private Node left;
    private Node right;

    /**
     * Constructor of node object.
     * @param valueChar character value.
     * @param value integer weight.
     */
    public Node(Character valueChar, int value) {
        this.value = value;
        this.valueChar = valueChar;
        this.left = null;
        this.right = null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Character getValueChar() {
        return valueChar;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
