package com.epam.university.java.core.task038;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexCount) {
        return new GraphImpl(vertexCount);
    }
}
