package com.epam.university.java.core.task012;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collection;

public class GraphImpl implements Graph {
    private Map<Integer, Set> adjMatrix;
    private int vertexesCount;

    /*
    * Constructor
     */
    public GraphImpl(int v) {
        adjMatrix = new HashMap<>(v);
        this.vertexesCount = v;
    }

    @Override
    public void createEdge(int from, int to) {
        if (adjMatrix.containsKey(from)) {
            adjMatrix.get(from).add(to);

        } else {
            Set<Integer> set = new HashSet<>();
            set.add(to);
            adjMatrix.put(from, set);
        }
        if (adjMatrix.containsKey(to)) {
            adjMatrix.get(to).add(from);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(from);
            adjMatrix.put(to, set);
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        return adjMatrix.get(from).contains(to) || adjMatrix.get(to).contains(from);
    }

    @Override
    public void removeEdge(int from, int to) {
        adjMatrix.get(from).remove(to);
        if (adjMatrix.get(from).size() == 0) {
            adjMatrix.remove(from);
        }
        adjMatrix.get(to).remove(from);
        if (adjMatrix.get(to).size() == 0) {
            adjMatrix.remove(to);
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return adjMatrix.get(from);
    }

}