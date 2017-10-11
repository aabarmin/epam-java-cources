package com.epam.university.java.core.task012;

/**
 * Created by ilya on 14.09.17.
 */
public class GraphFactoryImpl implements GraphFactory {

    @Override
    public Graph newInstance(int vertexesCount) {
        return new GraphImpl(vertexesCount);
    }
}
