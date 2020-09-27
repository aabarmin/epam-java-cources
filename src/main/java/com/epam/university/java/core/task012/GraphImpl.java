package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Some text.
 */
public class GraphImpl implements Graph {
    private Map<Integer, HashSet<Integer>> edgeRepository = new HashMap<>();
    private int vertexesCount;

    /**
    * Some text.
     */
    public GraphImpl(int vertexesCount) {
        if (vertexesCount == 0) {
            throw new IllegalArgumentException();
        }
        this.vertexesCount = vertexesCount;
        while (vertexesCount > 0) {
            edgeRepository.put(vertexesCount, new HashSet<>());
            vertexesCount--;
        }
    }

    public Map<Integer, HashSet<Integer>> getEdgeRepository() {
        return edgeRepository;
    }

    @Override
    public void createEdge(int from, int to) {
        if (edgeRepository.containsKey(from)) {
            edgeRepository.get(from).add(to);
        } else {
            throw new IllegalArgumentException();
        }

        if (edgeRepository.containsKey(to)) {
            edgeRepository.get(to).add(from);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        if (edgeRepository.containsKey(from)) {
            if (edgeRepository.get(from).contains(to)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeEdge(int from, int to) {
        if (edgeRepository.containsKey(from)) {
            edgeRepository.get(from).add(to);
            edgeRepository.get(from).remove(to);
        } else {
            throw new IllegalArgumentException();
        }

        if (edgeRepository.containsKey(to)) {
            edgeRepository.get(to).remove(from);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        if (edgeRepository.containsKey(from)) {
            return edgeRepository.get(from);
        }
        return null;
    }
}
