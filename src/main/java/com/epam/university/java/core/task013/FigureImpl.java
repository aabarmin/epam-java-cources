package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {
    private ArrayList<Vertex> vertices;
    private int maxVertices;

    public FigureImpl() {
        vertices = new ArrayList<Vertex>();
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (this.maxVertices > vertices.size()) {
            vertices.add(vertex);
        }
    }

    public int getMaxVertexes() {
        return maxVertices;
    }

    public void setMaxVertexes(int maxVertexes) {
        this.maxVertices = maxVertexes;
    }

    @Override
    public Collection<Vertex> getVertexes() {
        ArrayList<Vertex> result = new ArrayList<Vertex>(vertices);
        return result;
    }


}
