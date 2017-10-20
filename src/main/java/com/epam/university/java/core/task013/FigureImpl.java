package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {

    int vertexCount;

    Collection<Vertex> collectionOfVertexes = new ArrayList<>();

    FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        collectionOfVertexes.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return collectionOfVertexes;
    }
}
