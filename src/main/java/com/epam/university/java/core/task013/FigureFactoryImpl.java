package com.epam.university.java.core.task013;

public class FigureFactoryImpl implements FigureFactory {
    @Override
    public Figure newInstance(int vertexCount) {
        Figure f = new FigureImpl(vertexCount);
        return f;
    }

    @Override
    public Vertex newInstance(int x, int y) {
        Vertex newVertex = new VertexImpl();
        newVertex.setX(x);
        newVertex.setY(y);
        return newVertex;
    }
}