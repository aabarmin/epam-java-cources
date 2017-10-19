package com.epam.university.java.core.task036;

import java.util.function.Function;

/**
 * Created by Вера on 14.10.2017.
 */
public class IntegratorImpl implements Integrator {
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {

        // Квадратурная формула Ньютона-Котеса

        // Алгоритм построения ИКФ
        // 1. Задаем узлы квадратурной формулы - w(i), где i от 1 до n
        // 2. Вычисляем моменты m(i) весовой функции p(x), в данном случае
        // можно взять p(x) = 1
        // 3. Решаем СЛАУ:  сумма по j = 1-n (multiplyVector * w(j)^s) = m(i)^s
        // где s от 0 до n - 1
        // 4. Значение искомого интеграла который можно представить как p(x)*f(x) =
        // = сумма multiVector[i] * function(w[i]) где i от 1 до n


        int n = 3;
        double a = left;
        double b = right;
        double alf = (right - left) / (n - 1);
        double[] m = new double[n];

        for (int i = 0; i < n; i++) {
            // m = момент весовой функции  = интеграл от a до b x^i
            m[i] = Math.pow(b, i + 1) / (i + 1)
                    - Math.pow(a, i + 1) / (i + 1);
        }

        double[] w = new double[n]; // w - узлы (границы разбиения)
        for (int i = 0; i < n; i++) {
            w[i] = a + alf * i;
        }

        double[][] c = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = Math.pow(w[j], i);
            }
        }

        // буду искать обратную матрицу методом гаусса
        double[][] inverse = new double[n][2 * n]; // N строки в массив
        
        // заполняю исходную часть
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = c[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = n; j < 2 * n; j++) {
                if (i == (j - n)) {
                    inverse[i][j] = 1;
                } else {
                    inverse[i][j] = 0;
                }
            }
        }

        int t = 0;
        for (int i = 0; i < n; i++) { //i-индекс строки
            while (inverse[i][i] == 0 && i < n) { //пока первый элемент равен нулю
                // ищем такую строку в которой не равен нулю или переходим к следующей строке
                t = i;
                while (inverse[t][i] == 0 && t != n - 1) {
                    t++;
                }
                for (int j = 0; j < 2 * n; j++) {
                    double p = inverse[i][j];
                    inverse[i][j] = inverse[t][j];
                    inverse[t][j] = p;
                }
            }
            if (inverse[i][i] != 1) { //если первый элемент !=1
                // всю строку делим на этом элемент(нормируем)
                for (int j = i + 1; j < 2 * n; j++) { // j- индекс по стоблцу
                    inverse[i][j] = inverse[i][j] / inverse[i][i];
                }
                inverse[i][i] = 1;
            }
            for (int k = i + 1; k < n; k++) { //из оставшихся строк вычитаем i строку
                // умноженную на соотв коэфф. k-индекс по строке
                for (int j = i + 1; j < 2 * n; j++) { //j-индекс по столбцу
                    inverse[k][j] = inverse[k][j]
                            - inverse[i][j] * inverse[k][i];//вычитаем из k строки i-ую
                // sout (a[k][j] + " ");
                }
                inverse[k][i] = 0;
            }
        }


        for (int i = n - 1; i > 0; i--) {
            for (int k = i; k > 0; k--) {
                for (int j = n; j < 2 * n; j++) {
                    inverse[k - 1][j] = inverse[k - 1][j] - inverse[k - 1][i] * inverse[i][j];
                }
                inverse[k - 1][i] = 0;
            }
        }


        double[][] cInverse = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cInverse[i][j] = inverse[i][j + n];
            }
        }

        double[] multiVector = new double[n];

        //A = c^(-1)*m'
        //multiVector = cInverse * m
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                multiVector[i] += cInverse[i][j] * m[j];
            }
        }

        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + multiVector[i] * function.apply(w[i]);
        }

        return sum;
    }
}
