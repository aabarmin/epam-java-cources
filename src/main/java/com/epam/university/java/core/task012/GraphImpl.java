package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;

public class GraphImpl implements Graph {
    private int vertexCount;
    private Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();

    GraphImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        for (int i = 1; i <= vertexCount; i++) {
            adjacencyMap.put(i, new HashSet<>());
        }
    }

    @Override
    public void createEdge(int from, int to) {
        if (from > vertexCount || to > vertexCount) {
            throw new IllegalArgumentException("Wrong data");
        }
        Set<Integer> edges = adjacencyMap.get(from);
        edges.add(to);
        edges = adjacencyMap.get(to);
        edges.add(from);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        if (from > vertexCount || to > vertexCount) {
            return false;
        }
        Set<Integer> edges = adjacencyMap.get(from);
        return edges.contains(to);
    }

    @Override
    public void removeEdge(int from, int to) {
        Set<Integer> edges = adjacencyMap.get(from);
        edges.remove(to);
        edges = adjacencyMap.get(to);
        edges.remove(from);
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        if (from == 0 || from > vertexCount) {
            return Collections.emptySet();
        }
        return adjacencyMap.get(from);
    }
}