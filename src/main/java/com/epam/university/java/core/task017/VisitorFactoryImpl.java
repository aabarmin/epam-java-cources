package com.epam.university.java.core.task017;

/**
 * Factory of visitors.
 */
public class VisitorFactoryImpl implements VisitorFactory {

    /**
     * Create instance of visitor with the following type.
     * @param visitorType type of visitor
     * @return visitor instance
     */
    @Override
    public Visitor newInstance(VisitorType visitorType) {
        return new VisitorImpl(visitorType);
    }

}
