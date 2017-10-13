package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {
    private int valueX;
    private int valueY;

    @Override
    public int getX() {
        return valueX;
    }

    @Override
    public void setX(int value) {
        valueX = value;
    }

    @Override
    public int getY() {
        return valueY;
    }

    @Override
    public void setY(int value) {
        valueY = value;
    }
}
