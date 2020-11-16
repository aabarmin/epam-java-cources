package com.epam.university.java.core.task062;

import java.io.Serializable;

public class SingletonObjectImpl implements SingletonObject, Serializable {

    private static SingletonObject instance;


    /**
     * Default singleton constructor.
     */
    private SingletonObjectImpl() {
    }

    /**
     * Return or create (if not created yet) a singleton instance.
     *
     * @return singleton instance
     */
    public static SingletonObject getInstance() {
        if (instance == null) {
            instance = new SingletonObjectImpl();
        }
        return instance;
    }

    public Object readResolve() {
        return getInstance();
    }
}
