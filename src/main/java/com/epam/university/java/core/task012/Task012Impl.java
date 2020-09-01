package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Romin Nuro on 24.08.2020 23:49.
 */
public class Task012Impl implements Task012 {
    /**
     * Create new Graph instance and execute collection of actions. Return
     * the result graph instance.
     *
     * @param sourceGraph initial graph instance
     * @param actions     collection of actions
     * @return updated graph instance
     */
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null || actions.size() == 0) {
            throw new IllegalArgumentException();
        }
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    /**
     * Check is there path in <code>graph</code> between <code>from</code> and
     * <code>to</code> vertexes.
     *
     * @param graph graph instance
     * @param from  source vertex
     * @param to    target vertex
     * @return is path exists
     */
    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> toVisit = new LinkedList<>();

        toVisit.add(from);
        while (!toVisit.isEmpty()) {
            int vertex = toVisit.poll();
            visited.add(vertex);
            if (graph.getAdjacent(vertex).contains(to)) {
                return true;
            }
            for (int child : graph.getAdjacent(vertex)) {
                if (!visited.contains(child) && !toVisit.contains(child)) {
                    toVisit.add(child);
                }
            }
        }
        return false;
    }
}
