package com.epam.university.java.core.task039;

import java.util.Comparator;

public class NodeNotEqualComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getValue() == o2.getValue()
                && o1.getValueChar() != null
                && o2.getValueChar() != null) {
            return o1.getValueChar() - o2.getValueChar();
        } else if (o1.getValue() == o2.getValue() && o1.getValueChar() == null) {
            return -1;
        } else if (o1.getValue() == o2.getValue() && o2.getValueChar() == null) {
            return 1;
        } else {
            return o1.getValue() - o2.getValue();
        }
    }
}
