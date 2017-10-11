package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FigureImpl implements Figure {
    private int vertexCount;
    private List<Vertex> vertexes = new ArrayList<>();

    FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (vertexes.size() < vertexCount) {
            vertexes.add(vertex);
        }
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return new ArrayList<>(vertexes);
    }
}