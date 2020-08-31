package com.epam.university.java.core.task013;

public class FigureFactoryImpl implements FigureFactory {
    @Override
    public Figure newInstance(int vertexCount) {
        if (vertexCount < 3) {
            throw new IllegalArgumentException();
        }

        FigureImpl instance = new FigureImpl(vertexCount);
        return instance;
    }

    @Override
    public Vertex newInstance(int x, int y) {

        Vertex vertex = new VertexImpl();
        vertex.setX(x);
        vertex.setY(y);
        return vertex;
    }
}
