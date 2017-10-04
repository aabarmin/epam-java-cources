package com.epam.university.java.core.task013;

import java.util.Collection;

/**
 * Figure interface.
 */
public interface Figure {
    /**
     * Add vertex to figure with designated coordinates.
     *
     * @param vertex vertex to add
     */
    void addVertex(Vertex vertex);

    /**
     * Get all vertices of figure.
     *
     * @return collection of vertices
     */
    Collection<Vertex> getVertices();
}