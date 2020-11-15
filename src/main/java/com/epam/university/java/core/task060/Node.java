package com.epam.university.java.core.task060;

/**
 * Interface for cache node.
 */
public interface Node {
    /**
     * Getter for value.
     * @return value of Node.
     */
    String getValue();

    /**
     * Setter for value.
     * @param value of Node
     */
    void setValue(String value);

    /**
     * Getter for key.
     * @return key of Node.
     */
    int getKey();

    /**
     * Setter for key.
     * @param key of Node
     */
    void setKey(int key);

    /**
     * Getter for previous Node.
     * @return previous Node.
     */
    Node getPrev();

    /**
     * Setter for previous Node.
     * @param prev Node.
     */
    void setPrev(Node prev);

    /**
     * Getter for next Node.
     * @return next Node.
     */
    Node getNext();

    /**
     * Setter for next Node.
     * @param next Node.
     */
    void setNext(Node next);
}
