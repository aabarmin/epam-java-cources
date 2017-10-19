package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Вера on 29.09.2017.
 */
public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {
        Point[] points = new Point[3];
        int i = 0;

        for (Point p : minePositions) {
            points[i] = p;
            i++;
        }

        double cos120 = 120;

        if (angle(points[0], points[1], points[2]) >= cos120) {
            return points[1];
        }
        if (angle(points[1], points[2], points[0]) >= cos120) {
            return points[2];
        }
        if (angle(points[2], points[0], points[1]) >= cos120) {
            return points[0];
        }

        // если код программы дошел до этой части, значит все вглы в треугольнике
        // меньше 120 градусов и придется искать точку ферма - торричелли.

        /*Алгоритм
        Строим прямую АВ через 2 точки(А и В). Строим прямую перпендикулярную прямой АВ
        проходящую через середину отрезкка соединяющего исходные 2 точки.
        На этой прямой находим точку, расстояние до которой задается формулой длины высоты
        в равностороннем треугольнике. Соединяем найденную точку с третьей вершиной и находим
        первую прямую для точки ферма-торричелли.
        Аналогично с другими двумя точками.
        Точка ферма-торричелли будет пересечением найденных в каждом пункте прямых.
         */

        // точка "противоположная" вершине С
        PointImpl oppositeC = thirdVertex(points[0], points[1], points[2]);
        // прямая проходящая через точку С и "противоположную" ей
        double koeffC = 0;
        double bc = 0;
        if (oppositeC.getX() != points[2].getX()) {
            koeffC = (points[2].getY() - oppositeC.getY()) / (points[2].getX() - oppositeC.getX());
            bc = (oppositeC.getY() * points[2].getX() - oppositeC.getX() * points[2].getY())
                    / (points[2].getX() - oppositeC.getX());
        }

        // точка "противоположная" вершине В
        PointImpl oppositeA = thirdVertex(points[1], points[2], points[0]);
        // прямая проходящая через точку А и "противоположную" ей
        double koeffA = 0;
        double ba = 0;
        if (oppositeA.getX() != points[0].getX()) {
            koeffA = (points[0].getY() - oppositeA.getY()) / (points[0].getX() - oppositeA.getX());
            ba = (oppositeA.getY() * points[0].getX() - oppositeA.getX() * points[0].getY())
                    / (points[0].getX() - oppositeA.getX());
        }

        // ищем точку пересечения прямых просто по формулам
        double xIntersection = 0;
        double yIntersection = 0;

        if (oppositeA.getX() == points[0].getX()) {
            xIntersection = oppositeA.getX();
            yIntersection = koeffC * xIntersection + bc;
        } else if (oppositeC.getX() == points[2].getX()) {
            xIntersection = oppositeC.getX();
            yIntersection = koeffA * xIntersection + ba;
        } else {
            xIntersection = (ba - bc) / (koeffC - koeffA);
            yIntersection = (koeffC * ba - bc * koeffA) / (koeffC - koeffA);
        }


        PointImpl point = new PointImpl(xIntersection, yIntersection);

        return point;
    }

    // функции

    // вычисление угла ABC через вектора.

    private double angle(Point a, Point b, Point c) {
        double abX = a.getX() - b.getX();
        double abY = a.getY() - b.getY();
        double cbX = c.getX() - b.getX();
        double cbY = c.getY() - b.getY();

        double ba = Math.sqrt(abX * abX + abY * abY);
        double bc = Math.sqrt(cbX * cbX + cbY * cbY);

        double result = Math.acos((abX * cbX + abY * cbY) / (ba * bc));
        double resulttoDegree = Math.toDegrees(result);

        return resulttoDegree;
    }

    private PointImpl thirdVertex(Point a, Point b, Point c) {
        double koeff1 = 0;
        double b1 = 0;

        double x1 = a.getX();
        double y1 = a.getY();

        double x2 = b.getX();
        double y2 = b.getY();

        // координаты искомой точки
        double x1x2 = 0;
        double y1y2 = 0;

        double yMedium = (y1 + y2) / 2;
        double xMedium = (x1 + x2) / 2;

        double x3 = c.getX();
        double y3 = c.getY();

        // ищем прямую в виде y = kx + b

        if (x1 == x2) {
            // т.е. прямая, проходящая через эти 2 точки параллельна оси х
            y1y2 = (y1 + y2) / 2;
            if (x1 - x3 > 0) {
                // длина высоты - a * sin(alfa);
                x1x2 = x1 + Math.abs(y2 - y1) * Math.sqrt(3.0) / 2;
            } else {
                // длина высоты - a * sin(alfa);
                x1x2 = x1 - Math.abs(y2 - y1) * Math.sqrt(3.0) / 2;
            }
        }


        if (y1 == y2) {
            // т.е. прямая, проходящая через эти 2 точки параллельна оси y
            x1x2 = (x1 + x2) / 2;
            // если третья точка ниже прямой y = y1, то новую точку строим выше прямой
            if (y1 - y3 > 0) {
                // длина высоты - a * sin(alfa);
                y1y2 = y1 + Math.abs(x2 - x1) * Math.sqrt(3.0) / 2;
            } else {
                // длина высоты - a * sin(alfa);
                y1y2 = y1 - Math.abs(x2 - x1) * Math.sqrt(3.0) / 2;
            }
        }

        if (x1 != x2 && y1 != y2) {
            // крэффициент перпендикулярной прямой y = -1 / k;
            koeff1 = -1 / ((y2 - y1) / (x2 - x1));
            //b1 = (y1 * x2 - x1 * y2) / (x2 - x1);
            b1 = yMedium - koeff1 * xMedium;
            // т.е. на прямой y = koeff1 * x + b1 - будет лежать третья точка
            // равностороннего треугольника. И она должна лежать на окружности радиуса r
            // где r - длина высоты в равностороннем треугольнике = a * sin(alfa)
            // т.е. нужно решить следующую систему из 2-х уравнений относительно x1x2, y1y2
            // y1y2 = koeff1 * x1x2 + b1
            // r^2 = (y1y2 - yMedium)^2 + (x1x2 - xMedium)^2
            // вспомогательные обозначения:
            double r = Math.sqrt((x1 - x2) * (x1 - x2) + Math.pow(y1 - y2, 2))
                    * (Math.sqrt(3.0) / 2);
            double koeffA = (koeff1 * koeff1 + 1);
            double koeffB = 2 * (koeff1 * b1 - yMedium * koeff1 - xMedium);
            double koeffC = b1 * b1 - 2 * yMedium * b1
                    + yMedium * yMedium + xMedium * xMedium - r * r;
            double discriminant = Math.pow(koeffB,2) - 4 * koeffA * koeffC;

            x1x2 = (-koeffB + Math.sqrt(discriminant)) / (2 * koeffA);
            y1y2 = koeff1 * x1x2 + b1;
            PointImpl point = new PointImpl(x1x2, y1y2);

            // если вершина равностороннего треугольника и третья вершина исходного треугольника
            // лежат по одну сторону от прямой, берем другую вершину равностороннего треугольника
            if (angle(point, new PointImpl(xMedium, yMedium), c) < 90) {
                x1x2 = (-koeffB - Math.sqrt(discriminant)) / (2 * koeffA);
                y1y2 = koeff1 * x1x2 + b1;
            }

        }

        return new PointImpl(x1x2, y1y2);
    }
}
