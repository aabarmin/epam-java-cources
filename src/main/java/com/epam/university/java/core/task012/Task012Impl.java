package com.epam.university.java.core.task012;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        actions.forEach(a -> a.run(sourceGraph));
        return sourceGraph;
    }

    /*
    * Depth First Search
    */
    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        Set<Integer> marked = new HashSet<>();
        Queue<Integer> vertexQueue = new ArrayDeque<>();
        vertexQueue.add(from);
        while (!vertexQueue.isEmpty()) {
            int vertex = vertexQueue.remove();
            if (vertex == to || graph.edgeExists(vertex, to)) {
                return true;
            }
            marked.add(vertex);
            for (int v : graph.getAdjacent(vertex)) {
                if (!marked.contains(v)) {
                    vertexQueue.add(v);
                }
            }
        }
        return false;
    }
}
