package com.epam.university.java.core.task012;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Graphs and others.
 */
public class Task012Impl implements Task012 {

    /**
     * Create new Graph instance and execute collection of actions. Return
     * the result graph instance.
     *
     * @param sourceGraph initial graph instance
     * @param actions collection of actions
     * @return updated graph instance
     */
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    /**
     * Check if there is a path in <code>graph</code> between <code>from</code> and
     * <code>to</code> vertexes.
     *
     * @param graph graph instance
     * @param from source vertex
     * @param to target vertex
     * @return if path exists
     */
    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> vertexQueue = new ArrayDeque<>();
        vertexQueue.offer(from);
        while (!vertexQueue.isEmpty()) {
            int vertex = vertexQueue.poll();
            if (vertex == to || graph.edgeExists(vertex, to)) {
                return true;
            }
            visited.add(vertex);
            for (int v : graph.getAdjacent(vertex)) {
                if (!visited.contains(v)) {
                    vertexQueue.offer(v);
                }
            }
        }
        return false;
    }

}
