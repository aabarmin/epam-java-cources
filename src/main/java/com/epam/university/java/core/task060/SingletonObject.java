package com.epam.university.java.core.task060;
/*
 * Created by Laptev Egor 10.11.2020
 * */

import java.io.Serializable;

public class SingletonObject implements Serializable {
    private static SingletonObject instance;

    private SingletonObject() {
    }

    public static SingletonObject getInstance() {
        if (instance == null) {
            instance = new SingletonObject();
        }
        return instance;
    }

    private Object readResolve() {
        return getInstance();
    }
}
