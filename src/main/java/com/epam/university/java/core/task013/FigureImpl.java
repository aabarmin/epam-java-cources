package com.epam.university.java.core.task013;

import com.epam.university.java.core.utils.common.Validator;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Class implements <code>Figure</code>.
 */
public class FigureImpl implements Figure {

    private Set<Vertex> vertexSet;
    private int numberOfVertices;

    /**
     * Initialisation of <code>Figure</code>.
     *
     * @param numberOfVertices number of vertices
     * @throws IllegalArgumentException if <code>numberOfVertices</code> is
     * negative
     */
    public FigureImpl(int numberOfVertices) {
        Validator.validateNotNegative(numberOfVertices,
                Validator.MESSAGE_IF_NEGATIVE);
        this.numberOfVertices = numberOfVertices;
        this.vertexSet = new LinkedHashSet<>();
    }

    @Override
    public Collection<Vertex> getVertices() {
        return vertexSet;
    }

    @Override
    public void addVertex(Vertex vertex) {
        Validator.validateNotNull(vertex, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (vertexSet.size() == numberOfVertices) {
            System.out.println("figure is finished, no more vertices");
        } else {
            vertexSet.add(vertex);
        }
    }
}