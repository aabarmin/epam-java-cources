package com.epam.university.java.core.task012;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        return new GraphImpl(vertexesCount);
    }
}
