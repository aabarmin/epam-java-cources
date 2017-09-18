package com.epam.university.java.core.task013;

/**
 * Vertex of figure.
 */
public final class VertexImpl implements Vertex {

    /**
     * X coordinate of vertex.
     */
    private int x;

    /**
     * Y coordinate of vertex.
     */
    private int y;

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
    public void setX(final int value) {
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
    public void setY(final int value) {
        this.y = value;
    }
}
