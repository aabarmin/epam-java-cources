package com.epam.university.java.core.task015;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ilya on 16.09.17.
 */
public class Task015Impl implements Task015 {

    public static void main(String[] args) {
        PointFactory pointFactory = new PointFactoryImpl();
        SquareFactory squareFactory = new SquareFactoryImpl();
        Task015Impl impl = new Task015Impl();

        final Square firstSquare = squareFactory.newInstance(
            pointFactory.newInstance(2, 2),
            pointFactory.newInstance(4, 1)
        );

        Figure figure = impl.squareToFigure(firstSquare);
        System.out.println("");
    }

    @Override
    public double getArea(Square first, Square second) {
        Figure firstSquare = squareToFigure(first);
        Figure secondSquare = squareToFigure(second);

        List<Vertex> list = firstSquare.getVertex();
        list.addAll(secondSquare.getVertex());


        //  WeilerAthertonAlgorithm algorithm = new WeilerAthertonAlgorithm(firstSquare, secondSquare);
        //  Figure intersection = null;
        //  try {
        //      intersection = algorithm.getIntersection();
        //  } catch (IllegalArgumentException e) {
        //     return 0;
        // }

        return randomChecker(firstSquare, secondSquare);
    }

    private Figure squareToFigure(Square square) {
        PointFactory factory = new PointFactoryImpl();

        DoublePoint first = new DoublePoint(square.getFirst());
        DoublePoint third = new DoublePoint(square.getSecond());
        DoublePoint second = new DoublePoint(
            (first.getX() + third.getX()) / 2 - (third.getY() - first.getY()) / 2,
            (first.getY() + third.getY()) / 2 + (third.getX() - first.getX()) / 2);
        DoublePoint forth = new DoublePoint(
            (first.getX() + third.getX()) / 2 + (third.getY() - first.getY()) / 2,
            (first.getY() + third.getY()) / 2 - (third.getX() - first.getX()) / 2);
        List<DoublePoint> points = new LinkedList<>();
        Collections.addAll(points, first, second, third, forth);

        return new Figure(points);

    }

    private List<Double> getRangeX(Figure first, Figure second) {
        List<DoublePoint> list = first.getPoints();
        list.addAll(second.getPoints());

        double maxX = list.stream().mapToDouble(p -> p.getX()).max().getAsDouble();
        double minX = list.stream().mapToDouble(p -> p.getX()).min().getAsDouble();
        return Arrays.asList(minX, maxX);
    }

    private List<Double> getRangeY(Figure first, Figure second) {
        List<DoublePoint> list = first.getPoints();
        list.addAll(second.getPoints());

        double maxY = list.stream().mapToDouble(p -> p.getY()).max().getAsDouble();
        double minY = list.stream().mapToDouble(p -> p.getY()).min().getAsDouble();
        return Arrays.asList(minY, maxY);
    }


    private double randomChecker(Figure first, Figure second) {
        List<Double> rangeX = getRangeX(first, second);
        List<Double> rangeY = getRangeY(first, second);
        double startX = rangeX.get(0);
        double startY = rangeY.get(0);
        double rangeLenghX = rangeX.get(1) - rangeX.get(0);
        double rangeLenghY = rangeY.get(1) - rangeY.get(0);

        int i = 0;
        int count = 0;
        while (i != 1_000_000) {
            DoublePoint p = new DoublePoint(startX + Math.random() * rangeLenghX,
                startY + Math.random() * rangeLenghY);
            if (first.includes(p) && second.includes(p)) {
                count++;
            }
            //System.out.println(i);
            i++;

        }

        return ((double) count / 1000000.0) * rangeLenghX * rangeLenghY;

    }


}
