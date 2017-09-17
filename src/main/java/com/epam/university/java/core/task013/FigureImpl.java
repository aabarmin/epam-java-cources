package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ilya on 15.09.17.
 */
public class FigureImpl implements Figure {

    List<Vertex> vertexes = new LinkedList<>();

    @Override
    public void addVertex(Vertex vertex) {
        vertexes.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }
}
