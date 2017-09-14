package com.epam.university.java.core.task013;

/**
 * Factory for creation of figures.
 */
public interface FigureFactory {
    /**
     * Create figure with designated amount of vertexes.
     * @param vertexCount amount of vertexes
     * @return figure instance
     */
    Figure newInstance(int vertexCount);

    /**
     * Create new vertex instance with designated coordinates.
     * @param x first coordinate
     * @param y second coordinate
     * @return vertex instance
     */
    Vertex newInstance(int x, int y);
}
