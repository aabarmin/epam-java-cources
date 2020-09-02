package com.epam.university.java.core.task013;

import java.util.Objects;

public class VertexImpl implements Vertex {
    private int x;
    private int y;

    public VertexImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int value) {
        this.x = value;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int value) {
        this.y = value;
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
        return getX() == vertex.getX()
                && getY() == vertex.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
