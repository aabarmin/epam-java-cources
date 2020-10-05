package com.epam.university.java.core.task012;

public class GraphFactoryImpl implements GraphFactory {
    /**
     * Create new Graph instance with designated amount of vertexes.
     *
     * @param vertexesCount vertexes count
     * @return new graph instance
     */
    @Override
    public Graph newInstance(int vertexesCount) {
        if (vertexesCount <= 0) {
            throw new IllegalArgumentException();
        }
        GraphImpl graph = new GraphImpl(vertexesCount);
        graph.adjMatrix = new int[vertexesCount + 1][vertexesCount + 1];
        return graph;
    }
}
