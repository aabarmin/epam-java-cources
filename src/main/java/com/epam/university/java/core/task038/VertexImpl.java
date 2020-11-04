package com.epam.university.java.core.task038;

import java.util.Objects;

public class VertexImpl implements Vertex, Comparable<VertexImpl> {

    private int id;
    private int x;
    private int y;

    /**
     * Default constructor.
     */
    public VertexImpl() {
    }

    /**
     * Constructor with 3 params.
     *
     * @param id id of a vertex
     * @param x  x coordinate
     * @param y  y coordinate
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
    public int compareTo(VertexImpl vertex) {
        return this.id - vertex.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
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
}
