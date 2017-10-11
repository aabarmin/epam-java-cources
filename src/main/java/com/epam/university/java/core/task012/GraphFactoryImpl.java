package com.epam.university.java.core.task012;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        if (vertexesCount < 1) {
            throw new IllegalArgumentException("Wrong number of vertexes");
        }
        return new GraphImpl(vertexesCount);
    }
}