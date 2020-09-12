package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {
    Map<Integer, List<Integer>> graphMap = new HashMap<>();

    public GraphImpl(Map<Integer, List<Integer>> graphMap) {
        this.graphMap = graphMap;
    }

    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void createEdge(int from, int to) {
        validateVertexes(from, to);

        graphMap.get(from).add(to);
        graphMap.get(to).add(from);
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
        validateVertexes(from, to);

        return (graphMap.get(from).contains(to) || graphMap.get(to).contains(from));
    }

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void removeEdge(int from, int to) {
        validateVertexes(from, to);

        List<Integer> listOfVertexesFrom = graphMap.get(from);
        List<Integer> listOfVertexesTo = graphMap.get(to);

        if (listOfVertexesFrom.size() == 0 || listOfVertexesTo.size() == 0) {
            throw new IllegalArgumentException();
        }

        listOfVertexesFrom.remove(Integer.valueOf(to));
        listOfVertexesTo.remove(Integer.valueOf(from));

        graphMap.put(from, listOfVertexesFrom);
        graphMap.put(to, listOfVertexesTo);
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
            throw new IllegalArgumentException();
        }
        return graphMap.get(from);
    }

    private void validateVertexes(int from, int to) {
        if (!graphMap.containsKey(from) || !graphMap.containsKey(to)) {
            throw new IllegalArgumentException();
        }
    }
}
