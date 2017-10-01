package com.epam.university.java.core;

import java.util.Collection;

/**
 * Validator for checking null reference.
 */
public class Validator {

    private static volatile Validator instance;

    /**
     * Singleton with Double Checked Locking & volatile.
     *
     * @return instance of class
     */
    public static Validator getInstance() {
        Validator localInstance = instance;
        if (localInstance == null) {
            synchronized (Validator.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Validator();
                }
            }
        }
        return localInstance;
    }

    /**
     * Checking int for correct (pos) value.
     * <p>
     * Throwing IllegalArgumentException if finds neg or zero.
     * </p>
     *
     * @param i int
     */
    public void validatePos(int i) {
        if (i < 1) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checking connection for Empty.
     * <p>
     * Throwing IllegalArgumentException if finds null.
     * </p>
     *
     * @param object collection
     */
    public void vaildateNotEmpty(Collection object) {
        if (object.isEmpty()) {
            throw new IllegalArgumentException();
        }

    }

    /**
     * Checking varargs for null references.
     * <p>
     * Throwing IllegalArgumentException if finds null.
     * </p>
     *
     * @param objects varargs
     */
    public void vaildate(Object... objects) {
        if (objects == null) {
            throw new IllegalArgumentException();
        }
        for (Object obj : objects) {
            if (obj == null) {
                throw new IllegalArgumentException();
            }
        }
    }
}
