package com.epam.university.java.core.task012;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        // check for valid number of vertexes
        if (vertexesCount < 1) {
            throw new IllegalArgumentException("Illegal vertexes count");
        }

        return new GraphImpl(vertexesCount);
    }
}
