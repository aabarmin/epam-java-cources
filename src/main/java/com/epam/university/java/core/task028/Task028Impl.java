package com.epam.university.java.core.task028;

/**
 * Created by Вера on 05.10.2017.
 */

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {

        int rootValue = (int)Math.pow(value, 1.0 / power);

        return recurse(value, power, 0, rootValue);


        /*

        if (value <= 0) {
            return 0;
        }

        if (value == 1) {
            return 1;
        }

        if (value == Math.pow(2, power)) {
            return 1;
        }

        // если нет пути
        if (1 < value && value < Math.pow(2, power)) {
            return 0;
        }

        int count = 0; // количество путей
        if (value > Math.pow(2, power)) {

            // корень из переменной value степени power
            double rootValue = Math.pow(value, 1.0 / power);
            int a = (int) rootValue;
            int i = 0;

            // если корень извлекается из этого числа
            if (rootValue - (double)a == 0.0) {
                count++;
                // пока
                //while ( Math.abs(Math.pow(a - i, power) - value / 2) > 2) {
                while ( a - i - 1  > 0) {
                    //System.out.println(a - i - 1);
                    if (getWays(value - (int) Math.pow(a - i - 1, power), power) >= 1) {
                        count++;
                    }
                    i++;

                }


            } else {
                // если корень не извлекается
                //while ( Math.abs(Math.pow(a - i, power) - value / 2) > 2) {
                while ( a - i > 0) {
                    //System.out.println(a - i);
                    if (getWays(value - (int) Math.pow(a - i, power), power) >= 1) {
                        count++;
                    }
                    i++;
                }
            }

        }

        return count;
        */
    }

    private int recurse(int value, int power, int count, int rootValue) {
        if (count == rootValue || value < 0) {
            if (value == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int a = (int) rootValue - count;

        return recurse((int)(value - Math.pow(a, power)), power, count + 1, rootValue)
                +
        recurse(value, power, count + 1, rootValue);

    }


    /**
        Just to try.
     */
    public static void main(String[] args) {
        Task028Impl task028 = new Task028Impl();
        int rootValue = (int)Math.pow(10, 1.0 / 2);

        int c = task028.recurse(10,2, 0, rootValue);
        System.out.println();
        System.out.println(c);
    }
}