package com.epam.university.java.core.task012;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Вера on 17.09.2017.
 */
public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        Set<Integer> setVertex = new HashSet<>();
        for (int i = 1; i < vertexesCount + 1; i++) {
            setVertex.add(i);
        }
        Map<Integer,Set<Integer>> mapEdge = new HashMap<>();

        return new GraphImpl(mapEdge, setVertex);
    }
}
