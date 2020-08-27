package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;

public class GraphImpl implements Graph {
    private ArrayList<Edge> edges;


    GraphImpl(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public void createEdge(int from, int to) {
        Edge edgeFrom = getEdgeFromIndex(from);
        Edge edgeTo = getEdgeFromIndex(to);
        if (edgeFrom == null || edgeTo == null) {
            throw new IllegalArgumentException();
        }
        edgeFrom.addConnection(edgeTo);
        edgeTo.addConnection(edgeFrom);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        Edge edgeStart = getEdgeFromIndex(from);
        Edge edgeFinish = getEdgeFromIndex(to);
        return simpleTestContactThis2Edge(edgeStart, edgeFinish);
    }

    @Override
    public void removeEdge(int from, int to) {
        Edge edgeFrom = getEdgeFromIndex(from);
        Edge edgeTo = getEdgeFromIndex(to);
        if (edgeFrom == null || edgeTo == null) {
            throw new IllegalArgumentException();
        }
        edgeFrom.removeConnection(edgeTo);
        edgeTo.removeConnection(edgeFrom);
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return null;
    }

    boolean hasConnect(Edge start, Edge finish) {
        if (simpleTestContactThis2Edge(start, finish)) {
            return true;
        }
        ArrayList<Edge> connections1 = start.getConnections();
        start.setChecked(true);
        for (Edge edge1 : connections1) {
            if (!edge1.isChecked()) {
                return hasConnect(edge1, finish);
            }
        }
        return false;
    }

    Edge getEdgeFromIndex(int index) {
        Edge edgeFromIndex = null;
        for (Edge edge : edges) {
            if (edge.getIndex() == index) {
                edgeFromIndex = edge;
            }
        }
        return edgeFromIndex;
    }

    private boolean simpleTestContactThis2Edge(Edge edge1, Edge edge2) {
        return (edge1.connectTo(edge2) && edge2.connectTo(edge1)) || edge1.equals(edge2);
    }

    @Override
    public String toString() {
        StringBuilder edgesString = new StringBuilder();
        for (Edge edge : edges) {
            edgesString.append("\n").append(edge);
        }

        return edgesString.toString();
    }
}
