package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Вера on 20.09.2017.
 */
public class FigureImpl implements Figure {

    private Collection<Vertex> vertexes = new HashSet<>();

    @Override
    public void addVertex(Vertex vertex) {
        vertexes.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }
}
