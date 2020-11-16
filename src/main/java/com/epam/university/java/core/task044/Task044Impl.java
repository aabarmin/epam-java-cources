package com.epam.university.java.core.task044;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task044Impl implements Task044 {
    @Override
    public int findCountOfTraces(Integer points, List<String> lines) {
        if (points == null || lines == null) {
            throw new IllegalArgumentException();
        }

        int[] vertexes = new int[points];
        for (int i = 0; i < points; i++) {
            vertexes[i] = i;
        }

        for (String line : lines) {
            String[] edge = line.split(" ");
            int from = Integer.parseInt(edge[0]);
            int to = Integer.parseInt(edge[1]);
            for (int i = 0; i < vertexes.length; i++) {
                if (vertexes[i] == from - 1) {
                    vertexes[i] = to - 1;
                }
            }
        }

        int prev = -1;
        int amountOfFigures = 0;
        for (int vertex : vertexes) {
            if (vertex != prev) {
                amountOfFigures++;
            }
            prev = vertex;
        }

        return amountOfFigures;
    }
}
