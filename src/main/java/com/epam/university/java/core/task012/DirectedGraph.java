package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Александр on 14.09.2017.
 */
public class DirectedGraph implements Graph {
    private Map<Integer, Set<Integer>> network = new HashMap<>();

    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void createEdge(int from, int to) {
        if (network.containsKey(from)) {
            network.get(from).add(to);
        } else {
            network.put(from, new HashSet<Integer>());
            network.get(from).add(to);
        }
    }

    /**
     * Check is there edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     * @return is there edge between vertexes
     */
    @Override
    public boolean edgeExists(int from, int to) {
        if ((network.containsKey(from)) && (network.get(from).contains(to))) {
            return true;
        }
        return false;
    }

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void removeEdge(int from, int to) {
        if (network.containsKey(from)) {
            network.get(from).remove(to);
        }
    }

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     *
     * @param from vertex from
     * @return collection of available vertexes
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {
        if (network.containsKey(from)) {
            return network.get(from);
        }
        return new HashSet<Integer>();
    }
}
