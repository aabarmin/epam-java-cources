package com.epam.university.java.core.task038;

/**
 * Author Dmitry Novikov 21-Sep-20.
 */
public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexCount) {
        return new GraphImpl(vertexCount);
    }
}
