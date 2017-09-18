package com.epam.university.java.core.task012;

import com.epam.university.java.core.task012.exceptions.GraphInitializationException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


/**
 * Class for building Graph instances.
 */
public final class GraphFactoryImpl implements GraphFactory {
    /**
     * Create new Graph instance with designated amount of vertexes.
     *
     * @param vertexesCount vertexes count
     * @return new graph instance
     */
    @Override
    public Graph newInstance(final int vertexesCount) {
        return new GraphImpl(vertexesCount);
    }

    /**
     * Creates a copy of given graph.
     * @param graph - a graph to copy.
     * @return a copy of graph.
     */
    static Graph copy(final Graph graph) {
        if (null == graph) {
            throw new GraphInitializationException(
                    "Trying to copy null graph.");
        }

        // cloning object by serialization mechanism
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream ous = new ObjectOutputStream(baos)) {

            ous.writeObject(graph);

            ByteArrayInputStream bais
                    = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);


            return (Graph) ois.readObject();

        } catch (IOException ioe) {
            throw new GraphInitializationException("Copying of graph "
                    + "unsuccessful (serialization failed)", ioe);
        } catch (ClassNotFoundException cnfe) {
            throw new GraphInitializationException(
                    "Trying to copy non-instantiated graph.", cnfe);
        }
    }
}
