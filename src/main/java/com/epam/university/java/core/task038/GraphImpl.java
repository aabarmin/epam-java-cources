package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dmitry Novikov 21-Sep-20.
 */
public class GraphImpl implements Graph{
    private int vertexCount;
    private List<Vertex> vertexes;

    public GraphImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertexes = new ArrayList<>();
    }


    @Override
    public void createVertex(int id, int x, int y) {
        if (vertexCount > 0) {
            vertexes.add(new VertexImpl(id,x,y));
            vertexCount--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void connectVertices(int fromId, int toId) {

    }
}
