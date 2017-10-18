package com.epam.university.java.core.task012;

/**
 * {@inheritDoc}
 */
public class GraphFactoryImpl implements GraphFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Graph newInstance(int vertexesCount) {
        return new GraphImpl(vertexesCount);
    }
}
