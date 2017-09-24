package com.epam.university.java.core.task013;

public class FigureFactoryImpl implements FigureFactory {
    @Override
    public Figure newInstance(int vertexCount) {
        return new FigureImpl(vertexCount);
    }

    @Override
    public Vertex newInstance(int x, int y) {
        Vertex vertex = new VertexImpl();
        vertex.setX(x);
        vertex.setY(y);
        return vertex;
    }
}
