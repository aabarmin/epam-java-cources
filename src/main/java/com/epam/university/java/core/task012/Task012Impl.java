package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null) {
            throw new IllegalArgumentException("Data wasn't provided");
        }
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        Set<Integer> visitedVert = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(from);
        visitedVert.add(from);
        while (!stack.empty()) {
            Collection<Integer> setAdjVert = graph.getAdjacent(stack.peek());
            visitedVert.add(stack.peek());
            stack.pop();
            for (Integer i : setAdjVert) {
                if (visitedVert.contains(i)) {
                    continue;
                } else if (i.equals(to)) {
                    return true;
                }
                stack.push(i);
            }
        }
        return false;
    }
}