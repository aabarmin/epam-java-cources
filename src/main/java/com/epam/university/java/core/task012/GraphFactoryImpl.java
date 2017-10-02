package com.epam.university.java.core.task012;

/**
 * Implements factory of graphs
 */
public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int verticesCount) {
        return new GraphImpl(verticesCount);
    }
}
