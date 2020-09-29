package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class GraphImpl implements Graph {

    private Map<Integer, ArrayList<Integer>> graphMap = new TreeMap<>();

    public Map<Integer, ArrayList<Integer>> getGraphMap() {
        return graphMap;
    }

    /**
     * Constructor for Graph instance.
     * @param vertex number of graph vertex
     */
    public GraphImpl(int vertex) {
        if (vertex > 1) {
            for (int i = 1; i <= vertex; i++) {
                graphMap.put(i, new ArrayList<>());
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void createEdge(int from, int to) {
        if (from > graphMap.size() || to > graphMap.size()) {
            throw new IllegalArgumentException();
        }
        graphMap.get(from).add(to);
        graphMap.get(to).add(from);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        return graphMap.get(from).contains(to);
    }

    @Override
    public void removeEdge(int from, int to) {
        if (from > graphMap.size() || to > graphMap.size()) {
            throw new IllegalArgumentException();
        }
        graphMap.get(from).remove((Object) to);
        graphMap.get(to).remove((Object) from);
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return graphMap.get(from);
    }
}
