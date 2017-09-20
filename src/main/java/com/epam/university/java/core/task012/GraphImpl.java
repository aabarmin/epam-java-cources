package com.epam.university.java.core.task012;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class GraphImpl implements Graph {

    private final int vertexesCount;
    private final Map<Integer, Set<Integer>> vertexesEdges = new HashMap<>();

    public GraphImpl(int vertexesCount) {

        this.vertexesCount = vertexesCount;

        for (int i = 1; i <= vertexesCount; i++) {
            vertexesEdges.put(i, new HashSet<>());
        }

    }

    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void createEdge(int from, int to) {

        if (from == 0 || to == 0 || from == to || from > vertexesCount || to > vertexesCount) {
            throw new IllegalArgumentException();
        }

        Set<Integer> edges;
        edges = vertexesEdges.get(from);
        edges.add(to);

        // assumes what this is not oriented graph
        edges = vertexesEdges.get(to);
        edges.add(from);

    }

    /**
     * Check is there edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     * @return is there edge between vertexes
     */
    @Override
    public boolean edgeExists(int from, int to) {

        if (from == 0 || to == 0 || from == to  || from > vertexesCount || to > vertexesCount) {
            return false;
        }

        Set<Integer> edges = vertexesEdges.get(from);
        return edges.contains(to);

    }

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void removeEdge(int from, int to) {

        if (from == 0 || to == 0 || from == to  || from > vertexesCount || to > vertexesCount) {
            return;
        }

        Set<Integer> edges;
        edges = vertexesEdges.get(from);
        edges.remove(to);

        // assumes what this is not oriented graph
        edges = vertexesEdges.get(to);
        edges.remove(from);

    }

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     *
     * @param from vertex from
     * @return collection of available vertexes
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {

        if (from == 0 || from > vertexesCount) {
            return new HashSet<Integer>();
        }

        return vertexesEdges.get(from);

    }

}