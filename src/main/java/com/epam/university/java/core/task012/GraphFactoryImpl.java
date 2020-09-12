package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphFactoryImpl implements GraphFactory {

    /**
     * Create new Graph instance with designated amount of vertexes.
     *
     * @param vertexesCount vertexes count
     * @return new graph instance
     */
    @Override
    public Graph newInstance(int vertexesCount) {
        if (vertexesCount <= 0) {
            throw new IllegalArgumentException();
        }

        Map<Integer, List<Integer>> graphMap = new HashMap<>();

        for (int i = 1; i < vertexesCount + 1; i++) {
            graphMap.put(i, new ArrayList<>());
        }
        return new GraphImpl(graphMap);
    }
}
