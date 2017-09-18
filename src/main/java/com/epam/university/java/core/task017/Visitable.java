package com.epam.university.java.core.task017;

/**
 * Visitable interface.
 */
public interface Visitable {
    /**
     * Visit current node with visitor.
     * @param visitor visitor instance
     */
    void accept(Visitor visitor);
}
