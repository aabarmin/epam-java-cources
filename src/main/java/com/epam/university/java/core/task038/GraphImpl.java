package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {
    private final int vertexCount;
    private List<VertexImpl> vertexList;
    private Map<Integer, List<Integer>> paths = new HashMap<>();


    public GraphImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertexList = new ArrayList<>();
    }

    @Override
    public void createVertex(int id, int x, int y) {
        VertexImpl vertex = new VertexImpl(id, x, y);
        if (vertexList.size() == vertexCount) {
            throw new IllegalArgumentException();
        } else {
            vertexList.add(vertex);
            paths.put(id, new ArrayList<>());
        }
    }

    @Override
    public void connectVertices(int fromId, int toId) {
        List<Integer> toIds = paths.get(fromId);
        toIds.add(toId);
        paths.put(fromId, toIds);
    }

    public List<VertexImpl> getVertexList() {
        return vertexList;
    }

    public Map<Integer, List<Integer>> getPaths() {
        return paths;
    }
}
