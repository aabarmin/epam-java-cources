package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Вера on 20.09.2017.
 */
public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        // Идея проверки - построить минимальую выпуклую оболочку точек,
        // если все точки войдут в выпуклую оболочку - набор точек составляет выпуклую фигуру
        // если точек в выпуклой оболочке меньше количества исходных точек,
        // то множество невыпуклое

        // Алгоритм
        // найти самую нижнюю точку - это будет первая точка
        // отсортировать все оставшиеся точки относительно найденной первой точки
        // по возрастанию полярного угла
        // далее действовать по алгоритму Грэхема

        // поиск самой нижней точки (она явно будет входить в выпуклую оболочку)
        Iterator iterator = figure.getVertexes().iterator();
        VertexImpl whateverVertex = (VertexImpl)iterator.next();
        int minX = whateverVertex.getX();
        int minY = whateverVertex.getY();

        // сделаю список из вершин, чтобы с ними было удобнее работать
        ArrayList<Vertex> vertexArrayList = new ArrayList<>();

        for (Vertex v: figure.getVertexes()) {
            vertexArrayList.add(v);
            if (v.getY() < minY) {
                minX = v.getX();
                minY = v.getY();
            }
        }

        // найдена самая нижняя точка множества с координатами minX, minY
        int[] polarAngle = new int[figure.getVertexes().size()];
        int x; // ввожу обозначения для дальнейшего удобства использования
        int y;

        // sortVertex - массив вершин отсортированный по возрастанию полярного угла
        ArrayList<Vertex> sortVertex = new ArrayList<>();
        // вычисляю полярные углы для всех оставших точек относительно самой нижней точки множетсва
        for (int i = 0; i < polarAngle.length; i++) {
            x = vertexArrayList.get(i).getX();
            y = vertexArrayList.get(i).getY();
            if (minX == x && minY == y) {
                polarAngle[i] = 0;
                // записываем эту точку на первое место в список отстортированных
                // по полярному углу вершин
                sortVertex.add(vertexArrayList.get(i));
            }

            if (minX == x && minY != y) {
                polarAngle[i] = 90;
            }

            // если точка расположена правее относительно самой нижней точки
            if (minX < x) {
                //polarAngle[i] = 45 * (y - minY) / (x - minX);
                polarAngle[i] = (int)Math.toDegrees(Math.atan(1.0 * (y - minY) / (x - minX)));
                //System.out.println("x = " + x + ", y = " + y);
                //System.out.println("(y - minY) / (x - minX) = " + (y - minY) / (x - minX));
                //System.out.println("Math.atan = " + Math.atan(1.0 * (y - minY) / (x - minX)));
                //System.out.println("Math.toDegrees = "
                // + Math.toDegrees(Math.atan(1.0 * (y - minY) / (x - minX))));
                //System.out.println(polarAngle[i]);
            }

            // если точка расположена левее относительно самой нижней точки
            if (minX > x) {
                //polarAngle[i] = 90 + 45 * (y - minY) / (minX - x);
                polarAngle[i] = 180 - (int)Math.toDegrees(Math.atan(1.0 * (y - minY) / (minX - x)));
            }
        }

        // получили массив полярных углов
        // теперь сортируем его по возрастанию полярного угла
        int[] sortPolarAngle = new int[polarAngle.length];
        for (int i = 0; i < sortPolarAngle.length; i++) {
            sortPolarAngle[i] = polarAngle[i];
        }

        for (int i = sortPolarAngle.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortPolarAngle[j] > sortPolarAngle[j + 1]) {
                    int t = sortPolarAngle[j];
                    sortPolarAngle[j] = sortPolarAngle[j + 1];
                    sortPolarAngle[j + 1] = t;
                }
            }
        }

        // sortPolarAngle - отсортированный массив полярных углов
        // осталось сопоставить полярные углы с исходными вершинами,
        // чтобы выстроить их по возрастанию
        //ArrayList<Vertex> sortVertex = new ArrayList<>();

        // цикл начинается с 1 т.к. первая точка уже ранее добавлена в sortVertex
        for (int i = 1; i < sortPolarAngle.length; i++) {
            //System.out.println(sortPolarAngle[i]);
            for (int j = 0; j < polarAngle.length; j++) {
                if (sortPolarAngle[i] == polarAngle[j]
                        && (vertexArrayList.get(j).getX() != minX
                        || vertexArrayList.get(j).getY() != minY)) {
                    sortVertex.add(vertexArrayList.get(j));
                }
            }
        }

        // sortVertex - массив вершин отсортированный по возрастанию полярного угла

        // Нужно пройтись по всем вершинам и удалить те из них, в которых выполняется правый поворот
        // (угол в такой вершине оказывается больше развернутого).
        // Заводим список и помещаем в него первые две вершины
        // (они гарантированно входят в выпуклую оболочку).

        ArrayList<Vertex> stackVertexConvexHull = new ArrayList<>();
        stackVertexConvexHull.add(sortVertex.get(0));
        stackVertexConvexHull.add(sortVertex.get(1));

        // Затем просматриваем все остальные вершины, и отслеживаем направление поворота в них
        // с точки зрения последних двух вершин в листе(стеке): если это направление отрицательно,
        // то можно срезать угол удалением из листа(стека) последней вершины.
        // Как только поворот оказывается положительным, срезание углов завершается,
        // текущая вершина заносится в лист(стек).
        int v1x;
        int v1y;
        int v2x;
        int v2y;
        int v3x;
        int v3y;
        for (int i = 0; i < sortVertex.size() - 2; i++) {
            v1x = stackVertexConvexHull.get(stackVertexConvexHull.size() - 2).getX();
            v1y = stackVertexConvexHull.get(stackVertexConvexHull.size() - 2).getY();
            v2x = stackVertexConvexHull.get(stackVertexConvexHull.size() - 1).getX();
            v2y = stackVertexConvexHull.get(stackVertexConvexHull.size() - 1).getY();
            v3x = sortVertex.get(i + 2).getX();
            v3y = sortVertex.get(i + 2).getY();

            // формула для вычисления угла поворота
            // (B[0]-A[0])*(C[1]-B[1])-(B[1]-A[1])*(C[0]-B[0])

            if ((v2x - v1x) * (v3y - v2y) - (v2y - v1y) * (v3x - v2x) < 0) {
                stackVertexConvexHull.remove(stackVertexConvexHull.size() - 1);
                //stackVertexConvexHull.remove(i + 1);
                // stackVertexConvexHull.add(sortVertex.get(i + 2));
            }
            stackVertexConvexHull.add(sortVertex.get(i + 2));
        }


        if (stackVertexConvexHull.size() < vertexArrayList.size()) {
            return false;
        } else {
            return true;
        }

    }
}
