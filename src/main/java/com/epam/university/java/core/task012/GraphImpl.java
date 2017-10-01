package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GraphImpl implements Graph {
    int vertexesCount;

    ArrayList<Edge> edges = new ArrayList<>();

    GraphImpl(int vertexesCount) {
        this.vertexesCount = vertexesCount;
    }

    @Override
    public void createEdge(int from, int to) {

        edges.add(new Edge(from,to));
    }

    @Override
    public boolean edgeExists(int from, int to) {
        return edges.contains(new Edge(from, to))
                || edges.contains(new Edge(to, from));
    }

    @Override
    public void removeEdge(int from, int to) {

        edges.remove(new Edge(from, to));
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        ArrayList<Integer> adjacent = new ArrayList<>();
        for (Edge e: edges) {
            if (e.getFrom() == from) {
                adjacent.add(e.getTo());
            } else if (e.getTo() == from) {
                adjacent.add(e.getFrom());
            }
        }
        return adjacent;
    }

    public int getVertexesCount() {
        return vertexesCount;
    }
}

