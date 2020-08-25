package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexesCount) {
        Map<Integer, ArrayList<Integer>> graphMap = new HashMap<>();

        for (int i = 0; i < vertexesCount; i++) {
            graphMap.put(i + 1, new ArrayList<>());
        }

        return new GraphImpl(graphMap);
    }
}
