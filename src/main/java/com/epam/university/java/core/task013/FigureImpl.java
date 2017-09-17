package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Figure class.
 */
public class FigureImpl implements Figure {

    /**
     * Set of vertexes of the figure.
     */
    private Set<Vertex> vertexes = new HashSet<>();

    /**
     * Add vertex to figure with designated coordinates.
     *
     * @param vertex vertex to add
     */
    @Override
    public void addVertex(final Vertex vertex) {
        if (vertex != null) {
            this.vertexes.add(vertex);
        }

    }

    /**
     * Get all vertexes of figure.
     *
     * @return collection of vertexes
     */
    @Override
    public Collection<Vertex> getVertexes() {
        return new HashSet<>(this.vertexes);
    }
}
