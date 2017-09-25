package com.epam.university.java.core.task013;

import com.epam.university.java.core.utils.Validator;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class FigureImpl implements Figure {
    public FigureImpl(int numberOfVertexes) {
        this.numberOfVertexes = numberOfVertexes;
        this.vertexSet = new LinkedHashSet<>();
    }

    private Set<Vertex> vertexSet;
    private int numberOfVertexes;

    @Override
    public void addVertex(Vertex vertex) {
        Validator.validateNotNull(vertex, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (vertexSet.size() == numberOfVertexes) {
            System.out.println("figure is finished, no more vertexes");
        } else {
            vertexSet.add(vertex);
        }
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertexSet;
    }
}