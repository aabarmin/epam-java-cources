package com.epam.university.java.core.helper;

/**
 * Created by Aleksandr_Barmin on 8/31/2017.
 */
public class TestHelper {
    /**
     * Get instance for testing.
     *
     * @param testClass test class of class to get instance
     * @param <T> type of class
     * @return class instance
     * @throws Exception if can't find of create testable class
     */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<?> testClass) throws Exception {
        final Class<?> testableClass;
        final String testClassName = testClass.getName();
        if (testClassName.contains("Test")) {
            testableClass = Class.forName(testClassName.replace("Test", "Impl"));
        } else {
            testableClass = Class.forName(testClassName + "Impl");
        }
        return (T) testableClass.getDeclaredConstructor().newInstance();
    }
}