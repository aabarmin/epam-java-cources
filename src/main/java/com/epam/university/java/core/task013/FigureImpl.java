package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Romin Nuro on 26.08.2020 0:04.
 */
public class FigureImpl implements Figure {
    private final List<Vertex> vertexes;
    private final int vertexCount;

    public FigureImpl(int vertexCount) {
        vertexes = new ArrayList<>();
        this.vertexCount = vertexCount;
    }

    /**
     * Add vertex to figure with designated coordinates.
     *
     * @param vertex vertex to add
     */
    @Override
    public void addVertex(Vertex vertex) {
        if (vertexes.size() < vertexCount) {
            vertexes.add(vertex);
        } else {
            throw new IllegalArgumentException("Can't add vertex");
        }
    }

    /**
     * Get all vertexes of figure.
     *
     * @return collection of vertexes
     */
    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }
}
