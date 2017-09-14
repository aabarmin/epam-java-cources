package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Figure interface implementation.
 */
public class FigureImpl implements Figure {

    private List<Vertex> vertices;
    private final int vertexCount;
    private int verticesAdded;

    FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        vertices = new ArrayList<>(vertexCount);
    }

    /**
     * Add vertex to figure with designated coordinates.
     *
     * @param vertex vertex to add
     */
    @Override
    public void addVertex(Vertex vertex) {
        if (verticesAdded++ >= vertexCount) {
            throw new RuntimeException("too much vertices");
        }
        vertices.add(vertex);
    }

    /**
     * Get all vertexes of figure.
     *
     * @return collection of vertexes
     */
    @Override
    public Collection<Vertex> getVertexes() {
        return new ArrayList<>(vertices); // defencive copy
    }
}
