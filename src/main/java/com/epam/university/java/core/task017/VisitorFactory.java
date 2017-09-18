package com.epam.university.java.core.task017;

/**
 * Factory of visitors.
 */
public interface VisitorFactory {
    /**
     * Create instance of visitor with the following type.
     * @param visitorType type of visitor
     * @return visitor instance
     */
    Visitor newInstance(VisitorType visitorType);
}
