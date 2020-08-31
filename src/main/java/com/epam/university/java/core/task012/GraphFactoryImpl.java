package com.epam.university.java.core.task012;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        if (vertexesCount == 0) {
            throw new IllegalArgumentException();
        }
        GraphImpl graph = new GraphImpl();
        for (int i = 1; i <= vertexesCount; i++) {
            graph.addVertex(i);
        }
        return graph;
    }
}
