package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {

    public VertexImpl(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    private int xCoordinate;
    private int yCoordinate;

    @Override
    public int getX() {
        return xCoordinate;
    }

    @Override
    public void setX(int value) {
        this.xCoordinate = value;
    }

    @Override
    public int getY() {
        return yCoordinate;
    }

    @Override
    public void setY(int value) {
        this.yCoordinate = value;
    }

    @Override
    public String toString() {
        return "VertexImpl{" + "x=" + xCoordinate + ", y=" + yCoordinate
                + "}; ";
    }
}