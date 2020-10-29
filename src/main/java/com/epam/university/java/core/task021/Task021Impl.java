package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;

import java.util.ArrayList;
import java.util.Collection;

public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {

        if (minePositions == null || minePositions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        ArrayList<Point> listOfMinePositions = new ArrayList<>(minePositions);

        Point A = listOfMinePositions.get(0);
        Point B = listOfMinePositions.get(1);
        Point C = listOfMinePositions.get(2);




        return null;
    }
}
