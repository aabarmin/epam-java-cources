package com.epam.university.java.core.task012;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import com.epam.university.java.core.task012.exceptions.EdgeExistsException;
import com.epam.university.java.core.task012.exceptions.EdgeNotExistsException;
import com.epam.university.java.core.task012.exceptions.GraphInitializationException;
import com.epam.university.java.core.task012.exceptions.VertexNotExistsException;
import lombok.Data;

/**
 * Undirected graph.
 */
@Data
public final class GraphImpl implements Graph, Serializable {

    /**
     * Set of vertexes and edges corresponding to them.
     */
    private Map<Integer, Set<Integer>> vertexes;

    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void createEdge(final int from, final int to) {
        if (edgeExists(from, to)) {
            throw new EdgeExistsException("Edge already exists");
        } else {
            vertexes.get(from).add(to);
            vertexes.get(to).add(from);
        }
    }

    /**
     * Check is there edge between <code>from</code>
     * and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     * @return is there edge between vertexes
     */
    @Override
    public boolean edgeExists(final int from, final int to) {
        if (!vertexes.containsKey(from) || !vertexes.containsKey(to)) {
            throw new VertexNotExistsException("Vertex doesn't exist");
        }
        return (vertexes.get(from).contains(to)
                || vertexes.get(to).contains(from));
    }

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void removeEdge(final int from, final int to) {
        if (!edgeExists(from, to)) {
            throw new EdgeNotExistsException("Edge doesn't exist");
        } else {
            vertexes.get(from).remove(to);
            vertexes.get(to).remove(from);
        }
    }

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     *
     * @param from vertex from
     * @return collection of available vertexes
     */
    @Override
    public Collection<Integer> getAdjacent(final int from) {
        if (!vertexes.containsKey(from)) {
            throw new VertexNotExistsException("Vertex doesn't exist");
        }
        return new HashSet<>(vertexes.get(from));
    }

    /**
     * Initialization of empty graph.
     */
    GraphImpl() {
        vertexes = new HashMap<>();
    }

    /**
     * Initialization of graph with vertexes by given set of ids.
     *
     * @param vertexIds set of vertex ids.
     */
    GraphImpl(final Set<Integer> vertexIds) {

        vertexes = new HashMap<>();
        for (Integer id : vertexIds) {
            vertexes.put(id, new HashSet<>());
        }
    }

    /**
     * Initialization of graph with vertexes by given number of them.
     * Vertexes are assigned ids from 1 to vertexNumber
     *
     * @param vertexNumber number of vertexes to be in new graph.
     * @throws GraphInitializationException if vertexNumber<0
     */
    GraphImpl(final int vertexNumber) {
        if (vertexNumber < 0) {
            throw new GraphInitializationException(
                    "Number of vertexes can't be negative");
        }
        vertexes = new HashMap<>();
        for (int i = 1; i <= vertexNumber; i++) {
            vertexes.put(i, new HashSet<>());
        }
    }
}
