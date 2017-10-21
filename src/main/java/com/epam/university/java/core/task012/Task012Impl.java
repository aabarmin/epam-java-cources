package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction ga: actions) {
            ga.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {

        LinkedList<Integer> path = new LinkedList<>();
        int prevFrom = 0;
        int nextFrom = from;
        while (true) {
            for (int i : graph.getAdjacent(nextFrom)) {
                if (i != prevFrom) {
                    path.add(i);
                }
            }
            prevFrom = nextFrom;
            nextFrom = path.getLast();
            if (prevFrom == nextFrom) {
                break;
            } else if (path.size() > graph.getVertexesCount()) {
                break;
            }
        }
        return path.contains(to);
    }
}
