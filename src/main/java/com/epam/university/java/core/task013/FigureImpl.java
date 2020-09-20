package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author Dmitry Novikov.
 */
public class FigureImpl implements Figure {
    private final List<Vertex> vertexes;
    private final int vertexCount;

    public FigureImpl(int vertexCount) {
        vertexes = new ArrayList<>();
        this.vertexCount = vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (vertexes.size() < vertexCount) {
            vertexes.add(vertex);
        } else {
            throw new IllegalArgumentException("Can't add vertex");
        }
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }
}
