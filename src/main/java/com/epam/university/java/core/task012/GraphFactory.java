package com.epam.university.java.core.task012;

/**
 * Interface for building Graph instances.
 */
public interface GraphFactory {
    /**
     * Create new Graph instance with designated amount of vertexes.
     * @param vertexesCount vertexes count
     * @return new graph instance
     */
    Graph newInstance(int vertexesCount);
}
