package com.epam.university.java.core.task015;


import java.util.Objects;

public class Edge implements Comparable<com.epam.university.java.core.task038.Edge> {
    private Point from;
    private Point to;
    private double weight;

    /**
     * Default edge constructor.
     */
    public Edge() {
    }

    /**
     * Edge constructor.
     *
     * @param from   source Vertex
     * @param to     to Vertex
     * @param weight weight of the edge
     */
    public Edge(Point from, Point to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }


    public Point getFrom() {
        return from;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Edge edge = (Edge) o;
        return Double.compare(edge.getWeight(), getWeight()) == 0
                && (getFrom().equals(edge.getFrom())
                && getTo().equals(edge.getTo()))
                || (getFrom().equals(edge.getTo())
                && getTo().equals(edge.getFrom()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo(), getWeight());
    }

    @Override
    public String toString() {
        return "Edge{" + "from=" + from
                + ", to=" + to
                + ", weight="
                + weight + '}';
    }

    @Override
    public int compareTo(com.epam.university.java.core.task038.Edge edge) {
        return Double.compare(this.getWeight(), edge.getWeight());
    }
}