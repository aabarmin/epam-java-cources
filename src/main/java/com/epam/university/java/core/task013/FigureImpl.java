package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {
    private final int vertCount;
    private final ArrayList<Vertex> vertArray = new ArrayList<>();

    FigureImpl(int vertCount) {
        this.vertCount = vertCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertArray.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return vertArray;
    }
}
