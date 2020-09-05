package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author Dmitry Novikov.
 */
public class FigureImpl implements Figure {
    private List<Vertex> list = new ArrayList<>();
    private int vertexCount;

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        list.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return list;
    }
}
