package com.epam.university.java.core.task038;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VertexImpl implements Vertex {
    private int id;
    private int x;
    private int y;

    Collection<Vertex> shortestPath = Collections.emptyList();
    private Double distance = Double.MAX_VALUE;
    private Map<VertexImpl, Double> adjacentVertices = new HashMap<>();

    public Collection<Vertex> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(Collection<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Map<VertexImpl, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<VertexImpl, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    /**
     * Constructor for Vertex @class.
     * @param id = id for the Vertex
     * @param x = x-coordinate for the Vertex
     * @param y = y-coordinate for the Vertex
     */
    public VertexImpl(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
