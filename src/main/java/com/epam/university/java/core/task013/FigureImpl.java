package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {

    private final ArrayList<Vertex> vertices;
    private final int vertexCount;

    public FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertices = new ArrayList<>();
    }

    @Override
    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return this.vertices;
    }
}
