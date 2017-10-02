package com.epam.university.java.core.task012;

import java.util.Collection;

/**
 * Undirected graph.
 */
public interface Graph {
    /**
     * Create edge between <code>from</code> and <code>to</code> vertices.
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     */
    void createEdge(int from, int to);

    /**
     * Check is there edge between <code>from</code> and <code>to</code> vertices.
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     * @return is there edge between vertices
     */
    boolean edgeExists(int from, int to);

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertices.
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     */
    void removeEdge(int from, int to);

    /**
     * Get collection of vertices which is available from <code>from</code>.
     * @param from vertex from
     * @return collection of available vertices
     */
    Collection<Integer> getAdjacent(int from);
}
