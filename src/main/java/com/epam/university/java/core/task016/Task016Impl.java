package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;

public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        }
        Collection<Coordinate> inside = new ArrayList<>();
        radius *= 2;
        int currentX = radius - 1;
        int currentY = 1;
        while (currentY < radius) {
            if (currentX * currentX + currentY * currentY
                    <= radius * radius) {
                generateAndAdd(inside, currentX, currentY);
                currentY++;
            } else {
                currentX--;
            }
        }
        return inside;
    }

    private void generateAndAdd(Collection<Coordinate> dest,
                                int maxX, int y) {
        CoordinateFactory factory = new CoordinateFactoryImpl();
        for (int i = 1; i <= maxX; i++) {
            dest.add(factory.newInstance(i, y));
            dest.add(factory.newInstance(i, -y));
            dest.add(factory.newInstance(-i, y));
            dest.add(factory.newInstance(-i, -y));
        }
    }
}
