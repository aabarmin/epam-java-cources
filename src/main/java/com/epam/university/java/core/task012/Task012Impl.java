package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {

        if (sourceGraph == null || actions == null) {
            throw new IllegalArgumentException();
        }
        if (actions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        visited = new LinkedList<>();
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    LinkedList<Integer> visited = new LinkedList<>();

    @Override
    public boolean pathExists(Graph graph, int from, int to) {

        if (graph == null) {
            throw new IllegalArgumentException();
        }

        try {
            ArrayList<Integer> list = new ArrayList<>(graph.getAdjacent(from));
            if (graph.edgeExists(from, to)) {
                return true;
            }
            visited.add(from);

            for (Integer num : list) {
                if (!visited.contains(num)) {
                    if (pathExists(graph, num, to)) {
                        return true;
                    }
                }
            }

            return false;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

    }


}
