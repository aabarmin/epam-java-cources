package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {

        if (collection == null){
            throw new IllegalArgumentException();
        }

        if (collection.length == 0) {
            throw new IllegalArgumentException();
        }

        if (collection.length == 1) {
            return collection[0];
        }

        int num;

        if (collection.length % 2 == 0) {
            if (collection.length > 2) {
                num = 3;
            } else {
                num = 1;
            }
        } else {
            num = 1;
        }
        return collection[num];
    }

    @Override
    public String getLastName(ArrayList<String> collection) {

        if (collection == null){
            throw new IllegalArgumentException();
        }

        if (collection.size() == 0){
            throw new IllegalArgumentException();
        }

        if (collection.size() == 1) {
            return collection.get(0);
        }

        int num;

        if (collection.size() % 2 == 0) {
            if (collection.size() > 2) {
                num = 3;
            } else {
                num = 1;
            }
        } else {
            num = 1;
        }
        return collection.get(num);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {

        if (collection == null){
            throw new IllegalArgumentException();
        }

        if (collection.size() == 0){
            throw new IllegalArgumentException();
        }

        if (collection.size() == 1) {
            return collection.get(0);
        }

        int num;

        if (collection.size() % 2 == 0) {
            if (collection.size() > 2) {
                num = 3;
            } else {
                num = 1;
            }
        } else {
            num = 1;
        }
        return collection.get(num);
    }
}
