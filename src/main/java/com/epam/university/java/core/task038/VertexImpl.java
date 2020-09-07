package com.epam.university.java.core.task038;

import java.util.Objects;

public class VertexImpl implements Vertex, Comparable {
    private int id;
    private int x;
    private int y;

    /**
     * Constructor of Vertex point.
     * @param id of vertex.
     * @param x coordinate of vertex.
     * @param y coordinate of vertex.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VertexImpl)) {
            return false;
        }
        VertexImpl vertex = (VertexImpl) o;
        return getId() == vertex.getId()
                && getX() == vertex.getX()
                && getY() == vertex.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getX(), getY());
    }

    @Override
    public int compareTo(Object o) {
        VertexImpl vertex = (VertexImpl) o;
        return getId() - vertex.getId();
    }
}
