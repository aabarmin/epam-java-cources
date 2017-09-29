package com.epam.university.java.core.task013;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FigureImpl implements Figure {
    private int vertex = 0;
    private Set<Vertex> vertices = new HashSet<>();

    FigureImpl(int vertexCount) {
        vertex = vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertices;
    }
}
