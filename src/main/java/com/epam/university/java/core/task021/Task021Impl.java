package com.epam.university.java.core.task021;

import com.epam.university.java.core.task013.Vertex;
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

//      Get triangle points
        Point vertexA = listOfMinePositions.get(0);
        Point vertexB = listOfMinePositions.get(1);
        Point vertexC = listOfMinePositions.get(2);

//      Get angles

        double angleA = findAngle(vertexC, vertexA, vertexB);
        double angleB = findAngle(vertexA, vertexB, vertexC);
        double angleC = findAngle(vertexA, vertexC, vertexB);


        return null;

    }

    private double findAngle(Point vertexC, Point vertexA, Point vertexB) {
        double angle = 0.0;


        double modifiedXOfB;
        double modifiedYOfB;
        double modifiedXOfC;
        double modifiedYOfC;

        modifiedXOfB = vertexB.getX() - vertexA.getX();
        modifiedYOfB = vertexB.getY() - vertexA.getY();

        modifiedXOfC = vertexC.getX() - vertexA.getX();
        modifiedYOfC = vertexC.getY() - vertexA.getY();

        double scMul = modifiedXOfB * modifiedXOfC
                + modifiedYOfB * modifiedYOfC;
        double moduloOfB = Math.sqrt(Math.pow(modifiedXOfB, 2)
                + Math.pow(modifiedYOfB, 2));
        double moduloOfC = Math.sqrt(Math.pow(modifiedXOfC, 2)
                + Math.pow(modifiedYOfC, 2));
        double cosOfAngle = scMul / (moduloOfB * moduloOfC);

        angle = Math.acos(cosOfAngle);

        angle = Math.toDegrees(angle);
        return angle;
    }
}