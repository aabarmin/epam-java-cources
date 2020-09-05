package com.epam.university.java.core.task013;

/**
 * author Dmitry Novikov.
 */
public class FigureFactoryImpl implements FigureFactory {

    @Override
    public Figure newInstance(int vertexCount) {
        if (vertexCount < 3) {
            throw new IllegalArgumentException();
        }

        Figure f = new FigureImpl();
        for (int i = 0; i < vertexCount; i++) {
            f.addVertex(newInstance(0, 0));
        }

        return f;
    }

    @Override
    public Vertex newInstance(int x, int y) {
        return new VertexImpl(x, y);
    }
}
