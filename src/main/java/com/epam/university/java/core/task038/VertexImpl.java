package com.epam.university.java.core.task038;

/**
 * Author Dmitry Novikov 21-Sep-20.
 */
public class VertexImpl implements Vertex{
    // вершина (точка)
    private final int id;
    private final int x;
    private final int y;

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
}
