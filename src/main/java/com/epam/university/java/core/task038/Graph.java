package com.epam.university.java.core.task038;

/**
 * Undirected graph.
 */
public interface Graph {

    /**
     * Create vertex with given id, x and y coordinates.
     * @param id vertex id
     * @param x x coordinate
     * @param y y coordinate
     */

    void createVertex(int id, int x, int y);

    /**
     * Add connection directed from source vertex to target vertex.
     * @param fromId id of source vertex
     * @param toId id of target vertex
     */
    void connectVertices(int fromId, int toId);

}
