package com.epam.university.java.core.task038;

public class GraphFactoryImpl implements GraphFactory {

    @Override
    public Graph newInstance(int vertexCount) {
        if (vertexCount == 0) {
            throw new IllegalArgumentException();
        }
        return new GraphImpl(vertexCount);
    }
}
