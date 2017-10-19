package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Вера on 20.09.2017.
 */
public class FigureImpl implements Figure {

    //private Collection<Vertex> vertexes = new HashSet<>();
    private Collection<Vertex> vertexes = new ArrayList<>();
    private int countVertex;

    public FigureImpl(int countVertex) {
        this.countVertex = countVertex;
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertexes.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }
}
