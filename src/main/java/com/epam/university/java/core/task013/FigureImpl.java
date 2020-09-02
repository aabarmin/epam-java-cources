package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Dmitry Novikov 02-Sep-20
 */
public class FigureImpl implements Figure{
    List<Vertex> list = new ArrayList<>();

    @Override
    public void addVertex(Vertex vertex) {
        list.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return list;
    }
}
