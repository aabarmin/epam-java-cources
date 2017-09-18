package com.epam.university.java.core.task013;

/**
 * Factory for creation of figures.
 */
public final class FigureFactoryImpl implements FigureFactory {

    /**
     * Minimal number of vertexes to make a figure.
     */
    private static final int MIN_VERTEXES = 3;

    /**
     * Create figure with designated amount of vertexes.
     *
     * @param vertexCount amount of vertexes
     * @return figure instance or null if vertexCount < MIN_VERTEXES
     */
    @Override
    public Figure newInstance(final int vertexCount) {
        if (vertexCount < MIN_VERTEXES) {
            return null;
        }


        //do smth with vertexes, which coordinates????



        return null;
    }

    /**
     * Create new vertex instance with designated coordinates.
     *
     * @param x first coordinate
     * @param y second coordinate
     * @return vertex instance
     */
    @Override
    public Vertex newInstance(final int x, final int y) {
        Vertex result = new VertexImpl();
        result.setX(x);
        result.setY(y);
        return result;
    }
}
