package com.epam.university.java.core.task038;

/**
 * Interface for building Graph instances.
 */
public interface GraphFactory {
    /**
     * Create new Graph instance with designated amount of vertices.
     * @param vertexCount amount of vertices
     * @return new graph instance
     */
    Graph newInstance(int vertexCount);
}
