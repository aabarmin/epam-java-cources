package com.epam.university.java.core.task013;

/**
 * Created by Вера on 23.09.2017.
 */
public class FigureFactoryImpl implements FigureFactory {
    @Override
    public Figure newInstance(int vertexCount) {

        return new FigureImpl(vertexCount);
    }

    @Override
    public Vertex newInstance(int x, int y) {
        return new VertexImpl(x, y);
    }
}
