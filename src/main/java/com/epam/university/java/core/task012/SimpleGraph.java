package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Александр on 14.09.2017.
 */
public class SimpleGraph implements Graph {
    private Set<UndirectedEdge> edges = new HashSet<>();
    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void createEdge(int from, int to) {
        edges.add(new UndirectedEdge(from, to));
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
        return edges.contains(new UndirectedEdge(from, to));
    }

    /**
     * Remove edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void removeEdge(int from, int to) {
        edges.remove(new UndirectedEdge(from, to));
    }

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     *
     * @param from vertex from
     * @return collection of available vertexes
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {
        Set<Integer> result = new HashSet<>();
        int finalFrom = from;
        edges.forEach((e) -> {
            if (e.getFrom() == finalFrom) {
                result.add(e.getTo());
            } else if (e.getTo() == finalFrom) {
                result.add(e.getFrom());
            }
        });
        return result;
    }
}
