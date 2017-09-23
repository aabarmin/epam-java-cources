package com.epam.university.java.core.task012;

/**
 * Implementation class for GraphFactory.
 *
 * @author Sergei Titov
 */
public class GraphFactoryImpl implements GraphFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Graph newInstance(int vertexesCount) {
        return new GraphImpl();
    }
}
