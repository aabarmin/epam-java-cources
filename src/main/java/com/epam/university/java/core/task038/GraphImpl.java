package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GraphImpl implements Graph {


    private final int vertexCount;
    private final TreeMap<Vertex, ArrayList<Integer>> vertexes = new TreeMap<>();

    public GraphImpl(int vertexCount) {
        this.vertexCount = vertexCount;
    }


    @Override
    public void createVertex(int id, int x, int y) {
        VertexImpl vertex = new VertexImpl(id, x, y);
        vertexes.put(vertex, new ArrayList<>());
        if (vertexes.size() > vertexCount) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void connectVertices(int fromId, int toId) {
        ArrayList<Integer> currentLinks = null;
        for (Map.Entry<Vertex, ArrayList<Integer>> vertexEntry : vertexes.entrySet()) {
            if (vertexEntry.getKey().getId() == fromId) {
                currentLinks = vertexes.get(vertexEntry.getKey());
            }
        }
        if (currentLinks == null) {
            throw new IllegalArgumentException();
        }

        if (!currentLinks.contains(toId)) {
            currentLinks.add(toId);
        }
    }

    public TreeMap<Vertex, ArrayList<Integer>> getVertexes() {
        return vertexes;
    }
}
