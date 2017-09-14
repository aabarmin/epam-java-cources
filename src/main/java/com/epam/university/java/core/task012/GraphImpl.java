package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of the undirected graph.
 */
public class GraphImpl implements Graph {

    private final int vertexesCount;
    private ArrayList<Set<Integer>> adjacencyLists;

    /**
     * Constructs an undirected graph with designated amount of vertices.
     *
     * @param vertexesCount vertices count
     */
    public GraphImpl(int vertexesCount) {
        this.vertexesCount = vertexesCount;
        adjacencyLists = new ArrayList<>(vertexesCount);
        for (int i = 0; i < vertexesCount; ++i) {
            adjacencyLists.add(new HashSet<>());
        }
    }

    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     */
    @Override
    public void createEdge(int from, int to) {
        adjacencyLists.get(from - 1).add(to);
        adjacencyLists.get(to - 1).add(from);
    }

    /**
     * Check if there is an edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     * @return if there is an edge between vertexes
     */
    @Override
    public boolean edgeExists(int from, int to) {
        return adjacencyLists.get(from - 1).contains(to);
    }

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to vertex edge ends with
     */
    @Override
    public void removeEdge(int from, int to) {
        adjacencyLists.get(from - 1).remove(to);
        adjacencyLists.get(to - 1).remove(from);
    }

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     *
     * @param from vertex from
     * @return collection of available vertexes
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {
        if (from < 1 || from > vertexesCount) {
            throw new IndexOutOfBoundsException();
        }
        return adjacencyLists.get(from - 1);
    }
}
