package com.epam.university.java.core.task012;

import java.util.Collection;

/**
 * Undirected graph.
 */
public interface Graph {
    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     */
    void createEdge(int from, int to);

    /**
     * Check is there edge between <code>from</code> and <code>to</code> vertexes.
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     * @return is there edge between vertexes
     */
    boolean edgeExists(int from, int to);

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     */
    void removeEdge(int from, int to);

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     * @param from vertex from
     * @return collection of available vertexes
     */
    Collection<Integer> getAdjacent(int from);
}
