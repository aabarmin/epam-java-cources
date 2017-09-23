package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;

public class GraphImpl implements Graph {
    private int vertexCount;
    private boolean[][] isEdgeExist;

    public GraphImpl(int vertexCount) {
        this.vertexCount = ++vertexCount;
        isEdgeExist = new boolean[vertexCount][vertexCount];
    }

    @Override
    public void createEdge(int from, int to) {
        if (from != to) {
            isEdgeExist[from][to] = true;
            isEdgeExist[to][from] = true;
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        return isEdgeExist[from][to];
    }

    @Override
    public void removeEdge(int from, int to) {
        isEdgeExist[from][to] = false;
        isEdgeExist[to][from] = false;
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        Collection<Integer> adjacentVertex = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (isEdgeExist[from][i]) {
                adjacentVertex.add(i);
            }
        }
        return adjacentVertex;
    }
}
