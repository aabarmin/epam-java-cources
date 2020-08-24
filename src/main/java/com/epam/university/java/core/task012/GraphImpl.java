package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Romin Nuro on 24.08.2020 20:35.
 */
public class GraphImpl implements Graph {
    private final Map<Integer, Set<Integer>> graphMap;


    public GraphImpl() {
        this.graphMap = new HashMap<>();
    }

    public int getSize() {
        return graphMap.size();
    }

    public void createVertex(int vertex) {
        this.graphMap.put(vertex, new HashSet<>());
    }

    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void createEdge(int from, int to) {
        if (graphMap.containsKey(from) && graphMap.containsKey(to)) {
            graphMap.get(from).add(to);
            graphMap.get(to).add(from);
        } else {
            throw new IllegalArgumentException("One or both vertexes doesn't exist");
        }
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
        if (!graphMap.containsKey(from) || !graphMap.containsKey(to)) {
            throw new IllegalArgumentException("One or both vertexes doesn't exist");
        }
        return graphMap.get(from).contains(to);
    }

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void removeEdge(int from, int to) {
        if (!graphMap.containsKey(from) || !graphMap.containsKey(to)) {
            throw new IllegalArgumentException("One or both vertexes doesn't exist");
        }
        graphMap.get(from).remove(to);
        graphMap.get(to).remove(from);
    }

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     *
     * @param from vertex from
     * @return collection of available vertexes
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {
        if (!graphMap.containsKey(from)) {
            throw new IllegalArgumentException("Vertex doesn't exist");
        }
        return graphMap.get(from);
    }
}
