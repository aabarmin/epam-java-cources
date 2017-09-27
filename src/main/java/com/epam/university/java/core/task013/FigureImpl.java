package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class FigureImpl implements Figure {

    private final int vertexCount;
    private final Set<Vertex> vertexes = new LinkedHashSet<>();

    public FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    /**
     * Add vertex to figure with designated coordinates.
     *
     * @param vertex vertex to add
     */
    @Override
    public void addVertex(Vertex vertex) {
        if (vertexes.size() < vertexCount) {
            vertexes.add(vertex);
        }
    }

    /**
     * Get all vertexes of figure.
     *
     * @return collection of vertexes
     */
    @Override
    public Collection<Vertex> getVertexes() {
        return new LinkedHashSet(vertexes);
    }
}
