package com.epam.university.java.core.task062;

import java.io.Serializable;

public class SingletonObject implements Serializable {

    private static final SingletonObject instance = new SingletonObject();


    /**
     * Default singleton constructor.
     */
    private SingletonObject() {
    }

    /**
     * Return or create (if not created yet) a singleton instance.
     *
     * @return singleton instance
     */
    public static SingletonObject getInstance() {
        return instance;
    }

    public Object readResolve() {
        return getInstance();
    }


}
