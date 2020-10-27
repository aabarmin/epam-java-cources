package com.epam.university.java.core.task013;

public class FigureFactoryImpl implements FigureFactory {
    @Override
    public Figure newInstance(int vertexCount) {

        if (vertexCount < 3) {
            throw new IllegalArgumentException();
        }

        return new FigureImpl(vertexCount);
    }

    @Override
    public Vertex newInstance(int x, int y) {
        return new VertexImpl(x, y);
    }
}
