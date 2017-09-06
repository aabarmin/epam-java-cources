package com.epam.university.java.core.helper;

/**
 * Created by Aleksandr_Barmin on 8/31/2017.
 */
public class TestHelper {
    public static <T> T getInstance(Class<?> testClass) throws Exception {
        final Class<?> testableClass = Class.forName(testClass.getName().replace("Test", "Impl"));
        return (T) testableClass.newInstance();
    }
}
