package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(from);
        visited.add(from);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int v : graph.getAdjacent(vertex)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return visited.contains(to);
    }
}
