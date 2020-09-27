package com.epam.university.java.core.task039;

import java.util.Comparator;

/**
 * Author Dmitry Novikov 23-Sep-20.
 */
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        if (x.data == y.data) {
            return Character.compare(y.c, x.c);
        }
        return x.data - y.data;
    }
}