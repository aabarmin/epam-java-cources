package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FigureImpl implements Figure {
    List<Vertex> vertexList;
    private int vertexCount;

    public FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        vertexList = new ArrayList<>();
    }

    /**
     * Add vertex to figure with designated coordinates.
     *
     * @param vertex vertex to add
     */
    @Override
    public void addVertex(Vertex vertex) {
        if (vertexCount == getVertexes().size()) {
            throw new IllegalArgumentException();
        }
        vertexList.add(vertex);
    }

    /**
     * Get all vertexes of figure.
     *
     * @return collection of vertexes
     */
    @Override
    public Collection<Vertex> getVertexes() {
        return vertexList;
    }
}
