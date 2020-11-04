package com.epam.university.java.core.task038;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

import static java.lang.Math.pow;

public class Task038Impl implements Task038 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null) {
            throw new IllegalArgumentException();
        }

        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public Collection<Vertex> getShortestPath(Graph graph, int startId, int endId) {

        Vertex start = findVertexById(graph, startId);
        Vertex end = findVertexById(graph, endId);
        ArrayList<Edge> edges = findEdges(graph);
        Collections.sort(edges);

        return dijkstraAlgorithm(graph, edges, start, end);
    }

    private ArrayList<Vertex> dijkstraAlgorithm(Graph graph, ArrayList<Edge> edges,
                                                Vertex start, Vertex end) {
        final HashMap<Vertex, Double> vertexes = new HashMap<>();
        final TreeMap<Vertex, ArrayList<Integer>> vertexesOfGraph
                = ((GraphImpl) graph).getVertexes();
        for (Vertex vertex : vertexesOfGraph.keySet()) {
            vertexes.put(vertex, Double.POSITIVE_INFINITY);
        }

        vertexes.put(start, 0.0);

        final ArrayList<Vertex> checkedVertexes = new ArrayList<>();

        Vertex current = start;
        while (checkedVertexes.size() != vertexesOfGraph.size()) {

            for (Vertex vertex : vertexes.keySet()) {
                if (!checkedVertexes.contains(vertex)) {
                    current = vertex;
                }
            }

            //нахождение вершины с мин путем
            for (Map.Entry<Vertex, Double> vertexIntegerEntry : vertexes.entrySet()) {
                if (vertexes.get(current) > vertexIntegerEntry.getValue()
                        && !vertexes.containsKey(current)) {
                    current = vertexIntegerEntry.getKey();
                }
            }

            checkedVertexes.add(current);

            for (Edge edge : edges) {
                if (edge.getFrom().equals(current)) {
                    Vertex to = edge.getTo();
                    double distance = distanceBetweenVertices(current, to);
                    if (vertexes.get(to) > distance) {
                        vertexes.put(to, distance);
                    }
                }
            }
            current = null;
        }

        ArrayList<Vertex> path = new ArrayList<>();

        current = end;
        Vertex next = null;
        for (Map.Entry<Vertex, Double> entry : vertexes.entrySet()) {
            path.add(current);
            for (Edge edge : edges) {
                Vertex from = edge.getFrom();
                if (edge.getTo().equals(current)) {
                    if (next != null && vertexes.get(next) > vertexes.get(from)) {
                        next = from;
                    } else {
                        next = from;
                    }
                }
            }

            if (next == start) {
                path.add(next);
                break;
            } else if (next == null) {
                path = new ArrayList<>();
                break;
            } else {
                current = next;
                next = null;
            }
        }


        return path;
    }

    private ArrayList<Edge> findEdges(Graph sourceGraph) {
        GraphImpl graph = (GraphImpl) sourceGraph;
        TreeMap<Vertex, ArrayList<Integer>> vertexes = graph.getVertexes();
        ArrayList<Edge> edges = new ArrayList<>();

        for (Map.Entry<Vertex, ArrayList<Integer>> vertexEntry : vertexes.entrySet()) {
            Vertex from = vertexEntry.getKey();
            ArrayList<Integer> connections = vertexEntry.getValue();

            for (Integer connection : connections) {
                Vertex to = findVertexById(sourceGraph, connection);
                double weight = distanceBetweenVertices(from, to);
                edges.add(new Edge(from, to, weight));
            }
        }

        return edges;
    }

    private Vertex findVertexById(Graph sourceGraph, int id) {
        Vertex to = null;
        GraphImpl graph = (GraphImpl) sourceGraph;
        TreeMap<Vertex, ArrayList<Integer>> vertexes = graph.getVertexes();
        for (Vertex vertex : vertexes.keySet()) {
            if (vertex.getId() == id) {
                to = vertex;
                break;
            }
        }

        return to;
    }

    private double distanceBetweenVertices(Vertex from, Vertex to) {
        int x1 = from.getX();
        int y1 = from.getY();
        int x2 = to.getX();
        int y2 = to.getY();
        return Math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }
}