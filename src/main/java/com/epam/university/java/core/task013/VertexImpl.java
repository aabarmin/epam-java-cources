package com.epam.university.java.core.task013;

/**
 * Implementation class for Vertex.
 *
 * @author Sergei Titov
 */
public class VertexImpl implements Vertex {

    private int nodeX;
    private int nodeY;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {

        return nodeX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(int value) {
        nodeX = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {

        return nodeY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(int value) {
        nodeY = value;
    }
}
