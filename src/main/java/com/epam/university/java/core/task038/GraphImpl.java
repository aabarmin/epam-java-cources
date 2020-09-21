package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author Dmitry Novikov 21-Sep-20.
 */
public class GraphImpl implements Graph {
    private int vertexCount;
    private List<VertexImpl> vertexes;
    private Map<Integer, List<Integer>> connectedVertexesId;

    /**
     * Some text.
     */
    public GraphImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertexes = new ArrayList<>(vertexCount);
        connectedVertexesId = new HashMap<>();
    }

    public List<VertexImpl> getVertexes() {
        return vertexes;
    }

    public Map<Integer, List<Integer>> getConnectedVertexesId() {
        return connectedVertexesId;
    }

    @Override
    public void createVertex(int id, int x, int y) {
        if (vertexCount > 0) {
            vertexes.add(new VertexImpl(id, x, y));
            connectedVertexesId.put(id, new ArrayList<>());
            vertexCount--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void connectVertices(int fromId, int toId) {
        connectedVertexesId.get(fromId).add(toId);
    }
}
