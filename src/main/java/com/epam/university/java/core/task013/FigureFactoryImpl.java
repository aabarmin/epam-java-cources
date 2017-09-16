package com.epam.university.java.core.task013;


public class FigureFactoryImpl implements FigureFactory {
    @Override
    public Figure newInstance(int vertexCount) {
        FigureImpl figure = new FigureImpl();
        figure.setMaxVertexes(vertexCount);
        return figure;
    }

    @Override
    public Vertex newInstance(int x, int y) {
        return new VertexImpl(x, y);
    }
}
