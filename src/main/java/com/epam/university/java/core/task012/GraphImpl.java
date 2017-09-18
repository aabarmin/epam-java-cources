package com.epam.university.java.core.task012;

import java.util.*;

/**
 * Created by Вера on 17.09.2017.
 */
public class GraphImpl implements Graph {

    Map<Integer,Integer> mapEdge = new HashMap<>();
    List<Integer> vertexList = new ArrayList<>();
    Set<Integer> vertexSet = new HashSet<>();

    @Override
    public void createEdge(int from, int to) {


    }

    @Override
    public boolean edgeExists(int from, int to) {
        return false;
    }

    @Override
    public void removeEdge(int from, int to) {

    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return null;
    }
}
