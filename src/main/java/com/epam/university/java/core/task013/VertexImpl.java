package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {
    private int mxValue;
    private int myValue;

    public VertexImpl(int pxValue, int pyValue) {
        this.mxValue = pxValue;
        this.myValue = pyValue;
    }

    public VertexImpl() {
        this.mxValue = 0;
        this.myValue = 0;
    }

    @Override
    public int getX() {
        return mxValue;
    }

    @Override
    public void setX(int value) {
        this.mxValue = value;
    }

    @Override
    public int getY() {
        return myValue;
    }

    @Override
    public void setY(int value) {
        this.myValue = value;
    }
}
