package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Task011Impl implements Task011{
    /**
     * Given a circle of men, on each iteration one man leaves it through one. You should determine
     * name of last man.
     *
     * <p>
     *     Example: source collection: Homer Bart Maggie Lisa Marge
     *     First iteration: Homer leaves, Bart Maggie List Marge remained
     *     Second iteration: Maggie leaves, Bart List Marge remained
     *     Third iteration: Marge leaves, Bart and Lise remained
     *     Fourth iteration: Lisa leaves, Bart is the last one
     * </p>
     * <p>
     *     Implementation with arrays
     * </p>
     *
     * @param collection collection of names
     * @return name of last man
     */

    @Override
    public String getLastName(String[] collection) {
        TaskInit(collection);
        if (collection.length == 1){
            return collection[0];
        }
        int countOfRemovedGuys = 0;
        int guysInCircle = 0;
        collection[0] = null;
        while (countOfRemovedGuys != collection.length - 2){
            for (int i = 0; i < collection.length; i++) {
                if(collection[i] != null){
                    guysInCircle++;
                }
                if (guysInCircle % 2 == 0 && collection[i] != null){
                    collection[i] = null;
                    countOfRemovedGuys ++;
                }
            }
        }
        return getTheLuckyGuyName(collection);
    }
    /**
     *
     * <p>
     *     Implementation with ArrayList
     * </p>
     *
     */
    @Override
    public String getLastName(ArrayList<String> collection) {
        TaskInit(collection);
        if (collection.size() == 1){
            return collection.get(0);
        }
        int countOfRemovedGuys = 0;
        int guysInCircle = 0;
        collection.set(0, null);
        while (countOfRemovedGuys != collection.size() - 2){
            for (int i = 0; i < collection.size(); i++) {
                if(collection.get(i) != null){
                    guysInCircle++;
                }
                if (guysInCircle % 2 == 0 && collection.get(i) != null){
                    collection.set(i, null);
                    countOfRemovedGuys ++;
                }
            }
        }

        return getTheLuckyGuyName(collection);
    }
    /**
     *
     * <p>
     *     Implementation with LinkedList
     * </p>
     *
     */
    @Override
    public String getLastName(LinkedList<String> collection) {
        TaskInit(collection);
        if (collection.size() == 1) {
            return collection.get(0);
        }
        int position = 0;
        while (collection.size() != 1) {
            for (int i = 0; i < collection.size(); i++) {
                if (position % 2 == 0) {
                    collection.set(i, null);
                }
                position++;
            }
            collection.removeAll(Collections.singleton(null));
        }
        return collection.get(0);
    }

    private String getTheLuckyGuyName (String[] collectionForIteration){
        String name = "";
        for (String member:
             collectionForIteration) {
            if (member != null){
                name = member;
            }
        }
        return name;
    }

    private String getTheLuckyGuyName (Collection<String> collectionForIteration){
        String name = "";
        for (String member:
             collectionForIteration) {
            if (member != null){
                name = member;
            }
        }
        return name;
    }

    private void TaskInit(String[] col){
        if (col == null || col.length == 0){
            throw new IllegalArgumentException();
        }
    }

    private void TaskInit(Collection<String> col){
        if (col == null || col.size() == 0){
            throw new IllegalArgumentException();
        }
    }
}
