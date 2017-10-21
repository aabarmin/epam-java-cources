package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;
import edu.princeton.cs.algorithms.Point2D;
import java.util.ArrayList;
import java.util.Collection;

public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {

        ArrayList<Point2D> mines = new ArrayList<>();

        for (Point p: minePositions) {
            mines.add(new Point2D(p.getX(),p.getY()));
        }

        mines.sort(new Point2D(-25,25).POLAR_ORDER);

        double beginX = mines.get(0).x();

        double endX = mines.get(mines.size() - 1).x();

        double beginY = mines.get(0).y();

        double endY = mines.get(mines.size() - 1).y();

        double perimetr = 0;

        for (int i = 0; i < mines.size(); i++) {
            if (i + 1 < mines.size()) {
                perimetr += mines.get(i).distanceTo(mines.get(i + 1));
            } else {
                perimetr += mines.get(i).distanceTo(mines.get(0));
            }
        }

        double min = perimetr;

        double current;

        Point city = new PointImpl(0,0);

        for (double x = beginX; x < endX; x += 0.001) {
            for (double y = beginY; y < endY; y += 0.001) {

                current = 0;

                for (Point2D p: mines) {
                    current += new Point2D(x,y).distanceTo(p);
                }

                if (current < min) {
                    min = current;
                    city.setX(x);
                    city.setY(y);
                }

            }
        }
        return city;
    }

}
