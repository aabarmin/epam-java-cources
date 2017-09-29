package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {
    private int xcoord;
    private int ycoord;

    VertexImpl(int x, int y) {
        this.xcoord = x;
        this.ycoord = y;
    }

    @Override
    public int getX() {
        return xcoord;
    }

    @Override
    public void setX(int value) {
        this.xcoord = value;
    }

    @Override
    public int getY() {
        return ycoord;
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

        return xcoord == vertex.xcoord && ycoord == vertex.ycoord;
    }

    @Override
    public int hashCode() {
        int result = xcoord;
        result = 31 * result + ycoord;
        return result;
    }

    @Override
    public void setY(int value) {
        this.ycoord = value;
    }
}
