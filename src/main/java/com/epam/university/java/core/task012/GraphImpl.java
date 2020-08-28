package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {

    private final Map<Integer, List<Integer>> adjVertices;


    public GraphImpl() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(int label) {
        adjVertices.put(label, new ArrayList<>());
    }

    @Override
    public void createEdge(int from, int to) {
        adjVertices.get(from).add(to);
        adjVertices.get(to).add(from);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        if (!adjVertices.containsKey(from)) {
            return false;
        } else if (!adjVertices.containsKey(to)) {
            return false;
        } else {
            return adjVertices.get(from).contains(to) || adjVertices.get(to).contains(from);
        }
    }

    @Override
    public void removeEdge(int from, int to) {
        if (adjVertices.containsKey(from)) {
            adjVertices.get(from).remove(Integer.valueOf(to));
        }
        if (adjVertices.containsKey(to)) {
            adjVertices.get(to).remove(Integer.valueOf(from));
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return adjVertices.get(from);
    }
}
