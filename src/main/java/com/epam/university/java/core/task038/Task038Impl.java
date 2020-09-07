package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task038Impl implements Task038 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public Collection<Vertex> getShortestPath(Graph graph, int startId, int endId) {
        GraphImpl tmpGraph = (GraphImpl) graph;
        List<VertexImpl> vertices = tmpGraph.getVertexList();

        Map<Integer, List<Integer>> paths = tmpGraph.getPaths();
        List<Integer> path = paths.get(startId);

        Set<Vertex> resultCollection = new LinkedHashSet<>();
        resultCollection.add(getById(vertices, startId));

        if (path.contains(endId)) {
            resultCollection.add(getById(vertices, startId));
            resultCollection.add(getById(vertices, endId));
            return resultCollection;
        }

        if (path.size() <= 1) {
            return new ArrayList<>();
        } else {
            for (Integer id : path) {
                resultCollection.addAll(getShortestPath(graph, id, endId));
            }
        }

        resultCollection.add(getById(vertices, endId));
        return resultCollection;
    }

    private VertexImpl getById(List<VertexImpl> list, int id) {
        VertexImpl resVertex = null;
        for (VertexImpl vertex : list) {
            if (vertex.getId() == id) {
                resVertex = vertex;
            }
        }
        return resVertex;
    }
}
