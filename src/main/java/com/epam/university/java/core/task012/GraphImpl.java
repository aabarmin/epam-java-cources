package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphImpl implements Graph {
    // count of vertexes
    private final int vertCount;
    // collection of connections between vertexes
    private final Map<Integer, Set<Integer>> vertConnections;

    /**
     * Constructor - create new object of GraphImpl.
     *
     * @param vertexesCount quantity of vertexes in graph
     */
    GraphImpl(int vertexesCount) {
        this.vertCount = vertexesCount;
        this.vertConnections = new HashMap<>();

        // filling up Map of connections with keys
        for (int i = 1; i <= vertexesCount; i++) {
            vertConnections.put(i, new HashSet<>());
        }
    }

    @Override
    public void createEdge(int from, int to) {
        checkArguments("createEdge", from, to);

        // two-way values filling up
        vertConnections.get(from).add(to);
        vertConnections.get(to).add(from);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        checkArguments("edgeExists", from, to);

        return vertConnections.get(from).contains(to);
    }

    @Override
    public void removeEdge(int from, int to) {
        checkArguments("removeEdge", from, to);

        // two-way cleaning up values
        vertConnections.get(from).remove(to);
        vertConnections.get(to).remove(from);
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        checkArguments("getAdjacent", from);

        Set<Integer> adjacentSet = new HashSet<>();
        findConnections(adjacentSet, from);

        return adjacentSet;
    }

    /**
     * Filling up Set of direct and non-direct connections from the vertex.
     *
     * @param adjacentSet set of all connections from the vertex
     * @param from        vertex for which connections are looking up
     */
    private void findConnections(Collection<Integer> adjacentSet, int from) {
        for (Integer currentKey : vertConnections.keySet()) {
            if (vertConnections.get(currentKey).contains(from)) {
                if (!adjacentSet.contains(currentKey)) {
                    adjacentSet.add(currentKey);
                    findConnections(adjacentSet, currentKey);
                }
            }
        }
    }

    /**
     * Check arguments for valid values.
     *
     * @param callingMethod name of calling method
     * @param args          vararg of arguments
     * @throws IllegalArgumentException if arguments are not valid
     */
    private void checkArguments(String callingMethod, int... args) {
        for (int arg : args) {
            if (!(arg > 0 && arg <= vertCount)) {
                throw new IllegalArgumentException(
                        "Illegal args for " + callingMethod + "() method"
                );
            }
        }
    }
}
