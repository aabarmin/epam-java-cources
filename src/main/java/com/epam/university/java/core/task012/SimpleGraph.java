package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Александр on 14.09.2017.
 */
public class SimpleGraph implements Graph {
    private int[][] network;

    SimpleGraph(int vertexesCount) {
        this.network = new int[vertexesCount][vertexesCount];
    }

    /**
     * Create edge between <code>from</code> and <code>to</code> vertexes.
     *
     * @param from vertex edge starts from
     * @param to   vertex edge ends with
     */
    @Override
    public void createEdge(int from, int to) {
        from--;
        to--;
        network[from][to] = 1;
        network[to][from] = 1;
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
        from--;
        to--;
        if (network[from][to] == 1) {
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
        from--;
        to--;
        network[from][to] = 0;
        network[to][from] = 0;
    }

    /**
     * Get collection of vertexes which is available from <code>from</code>.
     *
     * @param from vertex from
     * @return collection of available vertexes
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {
        from--;
        List<Integer> result = new ArrayList<>();
        Arrays.stream(network[from]).forEach(result::add);
        return result;
    }
}
