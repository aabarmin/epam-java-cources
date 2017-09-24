package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FigureImpl implements Figure {
    private int vertexCount;
    private Set<Vertex> vertexes;

    public FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        vertexes = new HashSet<>(0);
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (vertexes.size() < vertexCount) {
            vertexes.add(vertex);
        }
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }
}
