package com.epam.university.java.core.task005;

import java.lang.reflect.Array;

/**
 * Created by Vadim on 21.09.2017.
 */
public class TestClass {

    static double first;
    static double second;

    public static void findPi(int digits) {


        double start =  Math.pow(10, digits - 1);
        double end =  Math.pow(10, digits);

        double min = 10;
        double current;
        for (double i = 3*start; i < end; i++) {

            for (double j = start; j < i + 1; j++) {
                current = Math.abs((i / j) - Math.PI);
                if (current < min) {
                    min = current;
                    first = i;
                    second = j;
                }
            }
        }
        System.out.println(first);
        System.out.println(second);
    }

    public static void main(String[] args) {
        findPi(3);
        System.out.println((int) (3*Math.pow(10, 2)));
    }
}
