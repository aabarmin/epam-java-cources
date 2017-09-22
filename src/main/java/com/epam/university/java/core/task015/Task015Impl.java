package com.epam.university.java.core.task015;

public class Task015Impl implements Task015 {
    @Override
    public double getArea(Square first, Square second) {
        return intersection(new CorrectFormSquare(first), new CorrectFormSquare(second));
    }

    class CorrectFormSquare {
        final Point point;
        final int width;
        private final int height;

        CorrectFormSquare(Square square) {
            Point first = square.getFirst();
            Point second = square.getSecond();

            width = Math.abs(first.getX() - second.getX());
            height = Math.abs(first.getY() - second.getY());

            int xLow = Math.min(first.getX(), second.getX());
            int yLow = Math.min(first.getY(), second.getY());
            point = new PointFactoryImpl().newInstance(xLow, yLow);
        }
    }

    private double intersection(CorrectFormSquare square1, CorrectFormSquare square2) {
        int xH = Math.max(square1.point.getX(), square2.point.getX());
        int yH = Math.max(square1.point.getY(), square2.point.getY());

        int width = Math.min(square1.point.getX() + square1.width, square2.point.getX() + square2.width) - xH;
        int height = Math.min(square1.point.getY() + square1.height, square2.point.getY() + square2.height) - yH;
        double area = width * height;
        return area>0 ? area : 0;
    }
}
