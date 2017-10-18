package com.epam.university.java.core.task012;


import java.util.Collection;
import java.util.HashSet;


/**
 * {@inheritDoc}
 */
public class GraphImpl implements Graph {

    private HashSet<Integer>[] vertexes;

    /**
     * Create new object of graph.
     *
     * @param numberOfVertexes quantity of vertex
     */
    @SuppressWarnings("unchecked")
    public GraphImpl(int numberOfVertexes) {
        vertexes = new HashSet[numberOfVertexes];
        for (int i = 0; i < vertexes.length; i++) {
            vertexes[i] = new HashSet<>();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createEdge(int from, int to) {
        vertexes[from - 1].add(to);
        vertexes[to - 1].add(from);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean edgeExists(int from, int to) {
        return vertexes[from - 1].contains(to);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEdge(int from, int to) {
        vertexes[from - 1].remove(to);
        vertexes[to - 1].remove(from);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {
        return vertexes[from - 1];
    }
}
