package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ilya on 13.09.17.
 */
public class GraphImpl implements Graph {

    private final Map<Integer, List<Integer>> points;
    private final List<Edge<Integer>> edges;
    private final int size;

    public GraphImpl(
        int pointsCount) {
        this.size = pointsCount;
        this.points = IntStream.range(1, pointsCount)
            .collect(HashMap<Integer, List<Integer>>::new,
                (list, i) -> list.put(i, new ArrayList<>()),
                HashMap<Integer, List<Integer>>::putAll);
        this.edges = new ArrayList<>();
    }

    private void checkPoint(int... points) {
        for (int point :
            points) {
            if (point > size) {
                throw new IllegalArgumentException(point + " is bigger then size of Graph " + size);
            }
        }
    }

    @Override
    public void createEdge(int from, int to) {
        checkPoint(from, to);

        edges.add(new Edge<Integer>(from, to));

        points.get(from).add(to);
        points.get(to).add(from);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        checkPoint(from, to);

        return edges.contains(new Edge<Integer>(from, to));
    }

    @Override
    public void removeEdge(int from, int to) {
        checkPoint(from, to);

        edges.remove(new Edge<Integer>(from, to));
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        checkPoint(from);
        return points.get(from);
    }
}
