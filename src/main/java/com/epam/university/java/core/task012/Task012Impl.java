package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction current: actions) {
            current.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> isVisited = new HashSet<>();
        stack.push(from);
        isVisited.add(from);
        while (!stack.empty()) {
            Collection<Integer> set = graph.getAdjacent(stack.peek());
            isVisited.add(stack.peek());
            stack.pop();
            for (Integer i: set) {
                if (isVisited.contains(i)) {
                    continue;
                }
                if (i.equals(to)) {
                    return true;
                }
                stack.push(i);
            }
        }
        return false;
    }
}
