package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {

    ArrayList<Vertex> listOfVertex = new ArrayList<>();
    private int vertexCount;

    public FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException();
        }
        if (listOfVertex.size() >= vertexCount) {
            throw new IllegalArgumentException();
        }
        listOfVertex.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return listOfVertex;
    }
}
