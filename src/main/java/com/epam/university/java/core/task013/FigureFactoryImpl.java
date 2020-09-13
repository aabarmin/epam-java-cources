package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.List;

public class FigureFactoryImpl implements FigureFactory {
    List<Vertex> vertexList = new ArrayList<>();

    /**
     * Create figure with designated amount of vertexes.
     *
     * @param vertexCount amount of vertexes
     * @return figure instance
     */
    @Override
    public Figure newInstance(int vertexCount) {
        if (vertexCount < 3) {
            throw new IllegalArgumentException();
        }
        return new FigureImpl(vertexCount);
    }

    /**
     * Create new vertex instance with designated coordinates.
     *
     * @param x first coordinate
     * @param y second coordinate
     * @return vertex instance
     */
    @Override
    public Vertex newInstance(int x, int y) {
        Vertex vert = new VertexImpl();
        vert.setX(x);
        vert.setY(y);
        return vert;
    }
}
