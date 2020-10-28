package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {

    Collection<Vertex> vertexes;
    private int vertexesCount;

    public FigureImpl() {
        vertexes = new ArrayList<>();
    }

    public FigureImpl(int vertexesCount) {
        this.vertexesCount = vertexesCount;
        vertexes = new ArrayList<>(vertexesCount);
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (vertexes.size() < vertexesCount) {
            vertexes.add(vertex);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }
}
