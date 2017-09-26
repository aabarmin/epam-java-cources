package com.epam.university.java.core.task013;

/**
 * Created by Александр on 16.09.2017.
 * Implevents vertex interface
 */
public class VertexImpl implements Vertex {
    private int x;
    private int y;

    VertexImpl(int x, int y) {
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
        return this.x;
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
        return this.y;
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
