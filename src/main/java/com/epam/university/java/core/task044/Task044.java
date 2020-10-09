package com.epam.university.java.core.task044;

import java.util.List;

/**
 * There are traces of sparrows in the snow .
 * You need to calculate their number.
 * The vertices of the graph start with 1.
 * Tip: a trace is a connected component or the free-standing point.
 */
public interface Task044 {

    /**
     * count of traces in the snow.
     * @param points total number of points
     * @param lines  each element is a two points separated by space
     * @return number of traces
     */
    int findCountOfTraces(Integer points, List<String> lines);
}
