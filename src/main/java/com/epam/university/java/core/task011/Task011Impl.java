package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(String[] collection) {
        int count = 0;
        String result = "";
        for (int i = 0; count < collection.length - 1; i = i + 2, count++) {
            if (i > collection.length) {
                i = i % collection.length;
            }
            result = collection[i];
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(ArrayList<String> collection) {
        int lastLoopSize = collection.size();
        for (int i = 0; lastLoopSize > 1; ) {
            collection.remove(i);
            if (i == collection.size()) {
                i = lastLoopSize % 2 == 0 ? 0 : 1;
                lastLoopSize = collection.size();
            } else {
                i++;
            }
        }
        return collection.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastName(LinkedList<String> collection) {
        boolean blackMark = true;
        while (collection.size() > 1) {
            Iterator<String> iterator = collection.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (blackMark) {
                    iterator.remove();
                    blackMark = !blackMark;
                } else {
                    blackMark = !blackMark;
                }
            }
        }
        return collection.peek();
    }
}
