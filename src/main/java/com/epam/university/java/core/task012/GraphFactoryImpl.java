package com.epam.university.java.core.task012;

/**
 * Implementation of the interface for building Graph instances.
 */
public class GraphFactoryImpl implements GraphFactory {

    /**
     * Create new Graph instance with designated amount of vertexes.
     *
     * @param vertexesCount vertexes count
     * @return new graph instance
     */
    @Override
    public Graph newInstance(int vertexesCount) {
        if (vertexesCount <= 0) {
            throw new IllegalArgumentException();
        }
        return new GraphImpl(vertexesCount);
    }

}
