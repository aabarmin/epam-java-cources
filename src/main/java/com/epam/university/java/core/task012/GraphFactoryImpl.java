package com.epam.university.java.core.task012;


public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        GraphImpl graph = new GraphImpl();
        for (int i = 1; i <= vertexesCount; i++) {
            graph.addVertex(graph.new Vertex(i));
        }
        return graph;
    }
}
