package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@inheritDoc}
 */
public class FigureImpl implements Figure {
    private Collection<Vertex> vertexes;

    /**
     * Create new figure with designated amount of vertexes.
     *
     * @param amountOfVertex amount of vertexes
     */
    protected FigureImpl(int amountOfVertex) {
        vertexes = new ArrayList<>(amountOfVertex);
    }

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
