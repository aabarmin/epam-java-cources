package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Александр on 16.09.2017.
 */
public class FigureImpl implements Figure {
    private List<Vertex> vertexList;

    FigureImpl(int vertexCount) {
        vertexList = new ArrayList<Vertex>(vertexCount);
    }

    /**
     * Add vertex to figure with designated coordinates.
     *
     * @param vertex vertex to add
     */
    @Override
    public void addVertex(Vertex vertex) {
        vertexList.add(vertex);
    }

    /**
     * Get all vertexes of figure.
     *
     * @return collection of vertexes
     */
    @Override
    public Collection<Vertex> getVertexes() {
        return vertexList.stream().collect(Collectors.toList());
    }
}
