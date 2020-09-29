package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Task012Impl implements Task012 {

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }
        int sizeOfList = ((GraphImpl) graph).getGraphMap().size();
        if (from > sizeOfList || to > sizeOfList) {
            throw new IllegalArgumentException();
        }
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(from);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Integer vert : graph.getAdjacent(vertex)) {
                    stack.push(vert);
                }
            }
        }
        return visited.contains(to);
    }
}
