package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {
    private ArrayList<Vertex> vertexes = new ArrayList<>();
    private int maxCountVertexes;

    FigureImpl(int maxCountVertexes) {
        this.maxCountVertexes = maxCountVertexes;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (vertexes.size() == maxCountVertexes) {
            throw new IllegalArgumentException();
        }
        vertexes.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Figure: ");
        for (Vertex vertex : vertexes) {
            string.append("\n").append(vertex.toString());
        }
        return string.toString();
    }
}
