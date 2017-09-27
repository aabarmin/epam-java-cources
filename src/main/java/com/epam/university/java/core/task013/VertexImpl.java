package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {

    private int x;
    private int y;

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
