package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class LineSegment {

    DoublePoint first;
    DoublePoint second;

    public LineSegment(DoublePoint first, DoublePoint second) {
        this.first = first;
        this.second = second;
    }

    public DoublePoint getFirst() {
        return first;
    }

    public void setFirst(DoublePoint first) {
        this.first = first;
    }

    public DoublePoint getSecond() {
        return second;
    }

    public void setSecond(DoublePoint second) {
        this.second = second;
    }


}
