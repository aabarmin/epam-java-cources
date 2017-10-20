package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {
    private int abscissa;
    private int ordinate;
    //private int abscissa;

    @Override
    public int getX() {
        return this.abscissa;
    }

    @Override
    public void setX(int value) {
        this.abscissa = value;
    }

    @Override
    public int getY() {
        return this.ordinate;
    }

    @Override
    public void setY(int value) {
        this.ordinate = value;
    }

}