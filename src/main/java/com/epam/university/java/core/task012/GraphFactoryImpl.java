package com.epam.university.java.core.task012;

/**
 * Created by Daniil Smirnov on 18.09.2017.
 * All copy registered MF.
 */
public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        return new GraphImpl(vertexesCount);
    }
}
