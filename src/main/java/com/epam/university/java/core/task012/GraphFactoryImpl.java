package com.epam.university.java.core.task012;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        if (vertexesCount == 0) {
            throw new IllegalArgumentException();
        }
        return new GraphImpl(vertexesCount);
    }
}
