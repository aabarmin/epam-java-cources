package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * {@inheritDoc}
 */
public class Task012Impl implements Task012 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        Graph graph = sourceGraph;
        for (GraphAction a : actions) {
            a.run(graph);
        }
        return graph;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(graph.getAdjacent(from));
        HashSet<Integer> visited = new HashSet<>();
        visited.add(from);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == to) {
                return true;
            } else {
                if (!visited.contains(poll)) {
                    queue.addAll(graph.getAdjacent(poll));
                    visited.add(poll);
                }
            }
        }
        return false;
    }
}

