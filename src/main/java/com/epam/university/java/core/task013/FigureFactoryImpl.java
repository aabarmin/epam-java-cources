package com.epam.university.java.core.task013;

/**
 * Implementation class for FigureFactory.
 *
 * @author Sergei Titov
 */
public class FigureFactoryImpl implements FigureFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Figure newInstance(int vertexCount) {
        return new FigureImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vertex newInstance(int x, int y) {
        Vertex vertex = new VertexImpl();

        vertex.setX(x);
        vertex.setY(y);
        return vertex;
    }
}
