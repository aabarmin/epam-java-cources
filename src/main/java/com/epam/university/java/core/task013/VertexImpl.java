package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {
    private int xcoord;
    private int ycoord;

    @Override
    public int getX() {
        return xcoord;
    }

    @Override
    public void setX(int value) {
        xcoord = value;
    }

    @Override
    public int getY() {
        return ycoord;
    }

    @Override
    public void setY(int value) {
        ycoord = value;
    }
}
