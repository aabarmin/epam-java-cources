package com.epam.university.java.core.task012;

public class Edge {
    private int from;
    private int to;

    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }


    public int getTo() {
        return to;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Edge edge = (Edge) obj;
        return (from == edge.from && to == edge.to)
                || (to == edge.from && from == edge.to);

    }
}
