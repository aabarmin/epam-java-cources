package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Some docs.
 */
public class Task012Impl implements Task012 {

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (actions == null || sourceGraph == null
                || actions.isEmpty()
        ) {
            throw new IllegalArgumentException();
        }

        for (GraphAction action : actions
        ) {
            action.run(sourceGraph);
        }

        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        if (graph == null || graph.getAdjacent(from) == null) {
            throw new IllegalArgumentException();
        }
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited.add(from);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for (Integer v : graph.getAdjacent(vertex)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        if (visited.contains(to)) {
            return true;
        } else {
            return false;
        }
    }
}
