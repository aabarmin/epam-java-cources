package com.epam.university.java.core.task013;

/**
 * Created by Romin Nuro on 26.08.2020 0:02.
 */
public class VertexImpl implements Vertex {
    private int x;
    private int y;

    public VertexImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x coordinate of vertex.
     *
     * @return coordinate value
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Set x coordinate of vertex.
     *
     * @param value coordinate value
     */
    @Override
    public void setX(int value) {
        this.x = value;
    }

    /**
     * Get y coordinate of vertex.
     *
     * @return coordinate value
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Set y coordinate of vertex.
     *
     * @param value coordinate value
     */
    @Override
    public void setY(int value) {
        this.y = value;
    }
}
