package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class GraphImpl implements Graph {
    public int vertexesCount;
    public int[][] adjMatrix;

    /**
     * Construrctor.
     *
     * @param vertexesCount number of vertexes
     */
    public GraphImpl(int vertexesCount) {
        this.vertexesCount = vertexesCount;
        this.adjMatrix = new int[vertexesCount + 1][vertexesCount + 1];
    }

    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void createEdge(int from, int to) {
        if (from > vertexesCount || to > vertexesCount) {
            throw new IllegalArgumentException();
        }
        this.adjMatrix[from][to] = 1;
        this.adjMatrix[to][from] = 1;
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
        if (adjMatrix[from][to] != 0) {
            return true;
        }
        return false;
    }

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void removeEdge(int from, int to) {
        if (from > vertexesCount || to > vertexesCount) {
            throw new IllegalArgumentException();
        }
        this.adjMatrix[from][to] = 0;
        this.adjMatrix[to][from] = 0;
    }

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     *
     * @param from vertex from
     * @return collection of available vertexes
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {
        LinkedList<Integer> adjacents = new LinkedList<>();
        for (int i = 1; i <= vertexesCount; i++) {
            if (adjMatrix[from][i] == 1) {
                adjacents.add(i);
            }
        }
        return adjacents;
    }
}
