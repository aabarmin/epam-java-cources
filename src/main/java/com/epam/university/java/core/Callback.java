package com.epam.university.java.core;


/**
 * Interface with default methods to wrap Exceptions to RuntimeExceptions.
 */
public interface Callback<T> {
    /**
     * function template for realization in lambda.
     *
     * @return T result of the function.
     */
    T run() throws Exception;


    /**
     * Wrap function with returned object.
     *
     * @param callback lambda realization.
     * @return T result of the function.
     */
    static <T> T runObject(Callback<T> callback) {
        try {
            return callback.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Wrap function with no returned object.
     *
     * @param callback lambda realization.
     */
    static <T> void runVoid(Callback<T> callback) {
        try {
            callback.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
