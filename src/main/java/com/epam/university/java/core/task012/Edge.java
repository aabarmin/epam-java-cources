package com.epam.university.java.core.task012;

import java.util.ArrayList;

public class Edge {
    private final int index;
    private boolean isChecked = false;
    private ArrayList<Edge> myConnections = new ArrayList<>();

    Edge(int index) {
        this.index = index;
    }


    int getIndex() {
        return index;
    }

    void addConnection(Edge edgeToAdd) {
        myConnections.add(edgeToAdd);
    }

    void removeConnection(Edge edgeToRemove) {
        myConnections.remove(edgeToRemove);
    }

    boolean connectTo(Edge edge) {
        return myConnections.contains(edge);
    }

    ArrayList<Edge> getConnections() {
        return myConnections;
    }


    boolean isChecked() {
        return isChecked;
    }

    void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        StringBuilder connections = new StringBuilder();
        for (Edge edge : myConnections) {
            connections.append(edge.index).append(" ");
        }
        return "Edge №" + index + " has connections to: " + connections;
    }
}
