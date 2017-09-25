package com.epam.university.java.core.task013;

/**
 * Created by Daniil Smirnov on 21.09.2017.
 * All copy registered MF.
 */
public class VertexImpl implements Vertex {
    private int pointX;
    private int pointY;

    public VertexImpl(int x, int y) {
        this.pointX = x;
        this.pointY = y;
    }

    @Override
    public int getPointX() {
        return pointX;
    }

    @Override
    public void setPointX(int value) {
        pointX = value;
    }

    @Override
    public int getPointY() {
        return pointY;
    }

    @Override
    public void setPointY(int value) {
        pointY = value;
    }
}
