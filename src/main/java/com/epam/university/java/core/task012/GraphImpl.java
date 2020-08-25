package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GraphImpl implements Graph {

    public Map<Integer, ArrayList<Integer>> vertexMap = new HashMap<>();

    public GraphImpl(Map<Integer, ArrayList<Integer>> vertexMap) {
        this.vertexMap = vertexMap;
    }

    @Override
    public void createEdge(int from, int to) {
        validateVertexes(from, to);

        ArrayList<Integer> connectFrom = vertexMap.get(from);
        if (!connectFrom.contains(to)) {
            connectFrom.add(to);
        }

        ArrayList<Integer> connectTo = vertexMap.get(to);
        if (!connectTo.contains(from)) {
            connectTo.add(from);
        }

        vertexMap.put(to, connectTo);
        vertexMap.put(from, connectFrom);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        Collection<Integer> connectFrom = vertexMap.get(from);
        Collection<Integer> connectTo = vertexMap.get(to);

        if (connectFrom.contains(to) && connectTo.contains(from)) {
            return true;
        }

        return false;
    }

    @Override
    public void removeEdge(int from, int to) {
        ArrayList<Integer> connectFrom = vertexMap.get(from);
        ArrayList<Integer> connectTo = vertexMap.get(to);

        connectFrom.remove(Integer.valueOf(to));
        connectTo.remove(Integer.valueOf(from));

        vertexMap.put(from, connectFrom);
        vertexMap.put(to, connectTo);
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return vertexMap.get(from);
    }

    public Map<Integer, ArrayList<Integer>> getVertexMap() {
        return vertexMap;
    }

    private void validateVertexes(int from, int to) {
        if (!vertexMap.containsKey(from) || !vertexMap.containsKey(to)) {
            throw new IllegalArgumentException();
        }
    }
}
