package com.epam.university.java.core.task013;

import java.util.Collection;

/**
 * Figure interface.
 */
public interface Figure {
    /**
     * Add vertex to figure with designated coordinates.
     * @param vertex vertex to add
     */
    void addVertex(Vertex vertex);

    /**
     * Get all vertexes of figure.
     * @return collection of vertexes
     */
    Collection<Vertex> getVertexes();
}
