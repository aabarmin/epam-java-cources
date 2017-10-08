package com.epam.university.java.core;

public interface Callback<T> {
    T run() throws Exception;

    static <T> T runObject(Callback<T> callback) {
        try {
            return callback.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static <T> void runVoid(Callback<T> callback) {
        try {
            callback.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
