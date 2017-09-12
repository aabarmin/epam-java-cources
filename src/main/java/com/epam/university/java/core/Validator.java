package com.epam.university.java.core;

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
     * Checking varargs for null references.
     *
     * <p>
     *     Throwing IllegalArgumentException if finds null.
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
