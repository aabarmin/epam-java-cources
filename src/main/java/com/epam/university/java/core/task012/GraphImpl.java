package com.epam.university.java.core.task012;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by Вера on 17.09.2017.
 */
public class GraphImpl implements Graph {

    // ключ - вершина
    // значение - множество вершин, доступных из данного ключа по прямому ребру
    private Map<Integer,Set<Integer>> mapEdge = new HashMap<>();
    // List<Integer> listVertex = new ArrayList<>();
    private Set<Integer> setVertex = new HashSet<>();

    public GraphImpl(Map<Integer, Set<Integer>> mapEdge, Set<Integer> setVertex) {
        this.mapEdge = mapEdge;
        this.setVertex = setVertex;
    }

    public Map<Integer, Set<Integer>> getMapEdge() {
        return mapEdge;
    }

    public Set<Integer> getSetVertex() {
        return setVertex;
    }

    @Override
    public void createEdge(int from, int to) {
        // если у этой вершины уже есть другие вершины доступные из исходной по прямому пути
        if (mapEdge.containsKey(from)) {
            Set<Integer> setNew = mapEdge.get(from);
            setNew.add(to);
            mapEdge.remove(from);
            mapEdge.put(from, setNew);
        } else {
            Set<Integer> setNew = new HashSet<>();
            setNew.add(to);
            mapEdge.put(from, setNew);
        }

        // если у этой вершины уже есть другие вершины доступные из исходной по прямому пути
        if (mapEdge.containsKey(to)) {
            Set<Integer> setNew = mapEdge.get(to);
            setNew.add(from);
            mapEdge.remove(to);
            mapEdge.put(to, setNew);
        } else {
            Set<Integer> setNew = new HashSet<>();
            setNew.add(from);
            mapEdge.put(to, setNew);
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        Set<Integer> setFrom = mapEdge.get(from);
        if (setFrom.contains(to)) {
            return true;
        }

        Set<Integer> setTo = mapEdge.get(to);
        if (setTo.contains(from)) {
            return true;
        }

        return false;
    }

    @Override
    public void removeEdge(int from, int to) {
        // из вершины from удаляем доступную вершину to
        Set<Integer> setFrom = mapEdge.get(from);
        setFrom.remove(to);
        mapEdge.remove(from);
        mapEdge.put(from, setFrom);

        // из вершины to удаляем доступную вершину from
        Set<Integer> setTo = mapEdge.get(to);
        setTo.remove(from);
        mapEdge.remove(to);
        mapEdge.put(to, setTo);

    }

    @Override
    public Collection<Integer> getAdjacent(int from) {

        if (mapEdge.containsKey(from)) {
            Set<Integer> setAvailableVertex = mapEdge.get(from);
            return setAvailableVertex;
        } else {
            return null;
        }
    }
}
