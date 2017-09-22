package com.epam.university.java.core.task013;

/**
 * {@inheritDoc}
 */
public class VertexImpl implements Vertex {
    private int x;
    private int y;

    /**
     * Create new vertex instance with designated coordinates.
     *
     * @param x coordinate X
     * @param y coordinate Y
     */
    protected VertexImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(int value) {
        this.x = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(int value) {
        this.y = value;
    }
}
