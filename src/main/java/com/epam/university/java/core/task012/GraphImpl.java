package com.epam.university.java.core.task012;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collection;

public class GraphImpl implements Graph {
    private int vertexes;
    private List<Set<Integer>> list = new ArrayList<>();

    GraphImpl(int vertexesCount) {
        vertexes = vertexesCount;
        for (int i = 0; i < vertexesCount; i++) {
            list.add(new HashSet<>());
        }

    }

    @Override
    public void createEdge(int from, int to) {
        if (from > vertexes || to > vertexes) {
            throw new IllegalArgumentException();
        }
        list.get(from - 1).add(to);
        list.get(to - 1).add(from);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        if (from > vertexes || to > vertexes) {
            throw new IllegalArgumentException();
        }
        return list.get(from - 1).contains(to);
    }

    @Override
    public void removeEdge(int from, int to) {
        if (from > vertexes || to > vertexes) {
            throw new IllegalArgumentException();
        }
        list.get(from - 1).remove(to);
        list.get(to - 1).remove(from);
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        if (from > vertexes) {
            throw new IllegalArgumentException();
        }
        return list.get(from - 1);
    }

}
