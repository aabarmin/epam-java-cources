package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.pow;

public class GraphImpl implements Graph {
    private final List<VertexImpl> listOfVertices = new ArrayList<>();
    private int numOfVertices;

    public List<VertexImpl> getListOfVertices() {
        return listOfVertices;
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public void setNumOfVertices(int numOfVertices) {
        this.numOfVertices = numOfVertices;
    }

    public GraphImpl(int numOfVertices) {
        this.numOfVertices = numOfVertices;
    }

    @Override
    public void createVertex(int id, int x, int y) {
        VertexImpl vertex = new VertexImpl(id, x, y);
        listOfVertices.add(vertex);
    }

    @Override
    public void connectVertices(int fromId, int toId) {
        VertexImpl from = null;
        VertexImpl to = null;
        double distanceBetweenVertices;
        for (VertexImpl vertex : listOfVertices) {
            if (fromId == vertex.getId()) {
                from = vertex;
            } else if (toId == vertex.getId()) {
                to = vertex;
            }
        }
        if (from != null && to != null) {
            int x1 = from.getX();
            int y1 = from.getY();
            int x2 = to.getX();
            int y2 = to.getY();
            distanceBetweenVertices = Math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
            Map<VertexImpl, Double> adjacentVerticesForSourceVertex = from.getAdjacentVertices();
            adjacentVerticesForSourceVertex.put(to, distanceBetweenVertices);
            from.setAdjacentVertices(adjacentVerticesForSourceVertex);
        }
    }
}
