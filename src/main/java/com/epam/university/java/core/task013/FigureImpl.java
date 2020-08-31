package com.epam.university.java.core.task013;

import java.util.Arrays;
import java.util.Collection;

public class FigureImpl implements Figure {
    private Vertex[] vertexes;
    private int lastIndex;

    public FigureImpl(int vertexCount) {
        this.vertexes = new Vertex[vertexCount];
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (lastIndex == vertexes.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == null) {
                vertexes[i] = vertex;
                lastIndex = i + 1;
                break;
            }
        }
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return Arrays.asList(vertexes);
    }
}
