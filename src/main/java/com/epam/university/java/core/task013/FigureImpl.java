package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class FigureImpl implements Figure {

    private final int vertexCount;
    private final List<Vertex> vertexes = new ArrayList<>();

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
        return new ArrayList(vertexes);
    }
}
