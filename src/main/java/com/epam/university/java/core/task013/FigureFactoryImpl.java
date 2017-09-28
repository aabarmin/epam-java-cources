package com.epam.university.java.core.task013;

/**
 * Created by Daniil Smirnov on 21.09.2017.
 * All copy registered MF.
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
