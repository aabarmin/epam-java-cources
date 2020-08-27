package com.epam.university.java.core.task012;

import java.util.ArrayList;

public class GraphFactoryImpl implements GraphFactory {

    @Override
    public Graph newInstance(int vertexesCount) {
        vertexesCount = vertexesCount + 1; //index start this 1;
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 1; i < vertexesCount; i++) {
            edges.add(new Edge(i));
        }
        return new GraphImpl(edges);
    }
}
