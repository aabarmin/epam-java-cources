package com.epam.university.java.core.task013;

/**
 * {@inheritDoc}
 */
public class FigureFactoryImpl implements FigureFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public Figure newInstance(int vertexCount) {
        return new FigureImpl(vertexCount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vertex newInstance(int x, int y) {
        return new VertexImpl(x, y);
    }
}
