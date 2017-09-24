package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation class for Figure.
 *
 * @author Sergei Titov
 */
public class FigureImpl implements Figure {

    private List<Vertex> vertexes = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void addVertex(Vertex vertex) {
        vertexes.add(vertex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Vertex> getVertexes() {
        return vertexes;
    }
}
